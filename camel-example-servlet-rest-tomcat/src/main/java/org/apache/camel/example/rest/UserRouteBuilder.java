/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.example.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * Define REST services using the Camel REST DSL
 */
public class UserRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // configure we want to use servlet as the component for the rest DSL
        // and we enable json binding mode
        restConfiguration().component("servlet")
            // and output using pretty print
            .dataFormatProperty("prettyPrint", "true")
        
            .contextPath("camel-example-servlet-rest-tomcat/rest").port(8080);


       /* rest("/user").description("User rest service")
            .consumes("text/xml").produces("text/xml")

            .get("/{id}")
             .route()
             .log("body is ${body} and id is ${headers.id}")
             .transform().simple("${headers.id}")
             .setHeader("Exchange.HTTP_URI")
            .simple("http://localhost:9000/customerservice/customers/${body}?bridgeEndpoint=true&amp;throwExceptionOnFailure=false")
            .to("http://dummy");
            */
        
     /*   from("jetty:http://0.0.0.0:7001/myapp?matchOnUriPrefix=true")
        .setHeader("Exchange.CONTENT_TYPE")
        .constant("text/xml")
        .setHeader("CamelHttpMethod")
        .constant("POST")
        .to("http://localhost:9000/customerservice/customers/?bridgeEndpoint=true&amp;throwExceptionOnFailure=false");
        */
        
        rest("/user").description("User rest service")
        .consumes("text/xml").produces("text/xml")
       
        
         .post().description("Updates or create a user")
         .route()
         .setHeader("client", constant("axis"))
             
             
        .transform()
         .simple("<Customer> <name>Apache Axis</name> </Customer>")
         
         .choice()
         .when(header("client").isEqualTo("axis"))
          .to("http://localhost:9000/customerservice/customers/?bridgeEndpoint=true&amp;throwExceptionOnFailure=false")
          .log("post message is ${body}");
            
              
    }

}