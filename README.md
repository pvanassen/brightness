# Christmas tree brightness

As a part of my christmas tree project, a micronaut client for providing the required brightness. 

The service can be configured using the following two settings: 
```
app.graphite.server: <Graphite server with /render endpoint>
app.graphite.luminosity.target: <Graphite target where statsd stores the luminosity values>
```

