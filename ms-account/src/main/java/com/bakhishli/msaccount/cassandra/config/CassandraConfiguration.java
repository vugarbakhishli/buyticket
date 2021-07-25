package com.bakhishli.msaccount.cassandra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${spring_cloud.cassandra.keyspace.name}")
    private String keySpaceName;

    @Value("${spring_cloud.cassandra.contact.point}")
    private String contactPoint;

    @Value("${spring_cloud.cassandra.port}")
    private int port;

    @Value("${spring_cloud.cassandra.username}")
    private String username;

    @Value("${spring_cloud.cassandra.password}")
    private String password;

    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.bakhishli.msaccount"};
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
        clusterFactoryBean.setUsername(username);
        clusterFactoryBean.setPassword(password);
        return clusterFactoryBean;
    }

    //    @Override
//    public CassandraClusterFactoryBean cluster(){
//        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
//    }
}
