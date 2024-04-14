package com.vecinet.post.domain.port;

public interface EnvironmentConfigPort {
    String getMongoUsername();
    String getMongoPassword();
    String getMongoCluster();
    String getMongoDatabase();
}
