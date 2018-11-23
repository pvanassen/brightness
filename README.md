# Christmas tree brightness

As a part of my christmas tree project, a micronaut client for providing the required brightness. 

Configuration can be done through the following environment variables:

For Graphite: 
- GRAPHITE_HOST
- GRAPHITE_PORT
- GRAPHITE_LUMINOSITY_TARGET

For Consul:
- CONSUL_ENABLED (defaults to true)
- CONSUL_HOST
- CONSUL_PORT

For Zipkin:
- ZIPKIN_ENABLED (defaults to true)
- ZIPKIN_HOST
- ZIPKIN_PORT
- ZIPKIN_PROBABILITY
