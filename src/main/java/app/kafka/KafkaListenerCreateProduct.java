package app.kafka;

import app.db.Repository.ProductRepository;
import app.dto.ProductDTO;
import app.dto.kafkadto.KafkaProductDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.Objects;

@Component
@Slf4j
public class KafkaListenerCreateProduct {

    private ProductRepository productRepository;
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private Connection connection;
    private Savepoint point;

    private Long nextCanceledProducts = 0L;

    @Autowired
    @Bean
    KafkaListenerCreateProduct createKafkaListener(ProductRepository productRepository,
                               JdbcTemplate jdbcTemplate,
                               DataSource dataSource) throws SQLException {
        this.productRepository = productRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;

        connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        return new KafkaListenerCreateProduct();
    }



    @KafkaListener(topics="load-test-create-product")
    public void productCreateListener(ConsumerRecord<String, KafkaProductDTO> record) throws SQLException {

        KafkaProductDTO product = record.value();

        if(this.nextCanceledProducts!=0){
            this.nextCanceledProducts--;
            return;
        }

        try{
            if(product.getThreadNumber() == 1){
                point = connection.setSavepoint();
            }

            Statement statement = connection.createStatement();
            String SQL = String.format("INSERT INTO product " +
                    "VALUES(%s,'%s','%s',%s,'%s',%s)",
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.isEnabled(),
                    product.getPhoto(),
                    product.getPrice());
            statement.executeUpdate(SQL);
            if(product.getThreadAmount().equals(product.getThreadNumber())){
                connection.commit();
                connection.releaseSavepoint(point);
            }
        }
        catch (SQLException ex){
            connection.rollback(point);
            this.nextCanceledProducts += product.getThreadAmount()-product.getThreadNumber();
        }

    }
}
