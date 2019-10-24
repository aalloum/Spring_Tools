package com.springtools.springbootcamel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootCamelApplication extends RouteBuilder {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCamelApplication.class, args);
    }

    @Override
    public void configure() throws Exception {
        System.out.println("started...");
        //moveAllFile();
        //moveSpecificFile("Test1");
        //moveSpecificFileWithBody("JAVA");
        //fileProcess();
        multiFileProcessor();
        System.out.println("End...");
    }

    public void moveAllFile() {
        // from("file:C:/Users/ALLOUM/Desktop/Workspace_Abdr/A?noop=true").to("file:C:/Users/ALLOUM/Desktop/Workspace_Abdr/B");
        from("file:src/main/resources/source?noop=true").to("file:src/main/resources/destination");
    }

    public void moveSpecificFile(String type) {
        from("file:src/main/resources/source?noop=true")
                .filter(header(Exchange.FILE_NAME).startsWith(type))
                .to("file:src/main/resources/destination");
    }

    public void moveSpecificFileWithBody(String content) {
        from("file:src/main/resources/source?noop=true")
                .filter(body().startsWith(content))
                .to("file:src/main/resources/destination");
    }

    public void fileProcess() {
        from("file:src/main/resources/source?noop=true").process(p -> {
            String body = p.getIn().getBody(String.class);
            StringBuilder sb = new StringBuilder();
            Arrays.stream(body.split(" ")).forEach(s -> {
                sb.append(s + ",");
            });
            p.getIn().setBody(sb);
        }).to("file:src/main/resources/destination?fileName=records.csv");
    }

    public void multiFileProcessor() {
        from("file:src/main/resources/source?noop=true").unmarshal().csv().split(body().tokenize(",")).choice()
                .when(body().contains("Closed")).to("file:src/main/resources/destination?fileName=close.csv")
                .when(body().contains("Pending")).to("file:src/main/resources/destination?fileName=Pending.csv")
                .when(body().contains("Interest")).to("file:src/main/resources/destination?fileName=Interest.csv");
    }
}
