# camel-microservice-a
sender application



hawtio

	<!-- add these two libraries -->
		<dependency>
			<groupId>io.hawt</groupId>
			<artifactId>hawtio-springboot</artifactId>
			<version>2.13.0</version>
		</dependency>

config properties

### hawtio can be configured as actuator
management:
  endpoints:
    web:
      base-path: /admin
      exposure:
        include: hawtio,jolokia,health
  server:
    port: 9001

## hawtio to disable authenthication
hawtio:
  authenticationEnabled: false
