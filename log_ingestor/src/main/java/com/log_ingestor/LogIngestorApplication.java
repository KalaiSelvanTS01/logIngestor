// package com.log_ingestor;

// /**
//  * Hello world!
//  *
//  */
// public class LogIngestorApplication 
// {
//     public static void main( String[] args )
//     {
//         System.out.println( "Hello World!" );
//     }
// }

package com.log_ingestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogIngestorApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogIngestorApplication.class, args);
    }
}
