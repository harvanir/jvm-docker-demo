# JVM Docker Demo

## Run docker JVM options test  
```shell script
sh docker-compose-up-jvmtest.sh
```

## Run docker JVM Memory Eater
Run command bellow 
```shell script
sh src/main/java/docker-build.sh
```
```shell script
sh docker-compose-up-memoryeater.sh
```

### Docker parameter
* <code>SLEEP_EACH_ITERATE_IN_MILLIS</code> Sleep in millis each iteration.
* <code>JVM_OPT</code> Java option. 
* <code>JMX</code> Java option related with JMX.