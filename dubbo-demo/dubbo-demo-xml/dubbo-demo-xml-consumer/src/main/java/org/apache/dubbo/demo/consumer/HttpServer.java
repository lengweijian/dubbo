package org.apache.dubbo.demo.consumer;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

public class HttpServer {

    private static final String CONTEXTPATH = "";

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    private static final String MATCH_PATH = "\"/*\"";

    private Tomcat tomcat;

    public HttpServer(String hostName, Integer port){
        initConfig(hostName,port);
        serverStart();
        serverDestroy();
    }

    private void serverDestroy() {
        // TODO
    }

    private void serverStart() {
        // 启动tomcat
        try {
            this.tomcat.start();
            this.tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    private void initConfig(String hostName, Integer port) {
        // 设置添加servlet
        addServletConfig(getTomcat(hostName,port));
    }


    public Tomcat getTomcat(String hostName,Integer port){
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");
        serviceConfig(hostName,service,port);
        this.tomcat = tomcat;
        //设置核心servlet
        return tomcat;
    }

    private void serviceConfig(String hostName,Service service,Integer port) {
        Connector connector = new Connector();
        Engine engine = new StandardEngine();
        engineConfig(engine,hostName,connectorConfig(connector,port,hostName));
        // 将engine和connector添加到service
        service.setContainer(engine);
        service.addConnector(connector);
    }

    private void engineConfig(Engine engine, String hostName,Host host) {
        engine.setDefaultHost(hostName);
        engine.addChild(host);
    }

    private Host connectorConfig(Connector connector, Integer port,String hostName) {
        connector.setPort(port);
        Host host = new StandardHost();
        host.setName(hostName);
        host.addChild(contextConfig());
        return host;
    }

    private Context contextConfig() {
        Context context = new StandardContext();
        context.setPath(CONTEXTPATH);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        context.addServletMappingDecoded(MATCH_PATH, DISPATCHER_SERVLET_NAME);
        return context;
    }

    public void addServletConfig(Tomcat tomcat){
       // tomcat.addServlet(CONTEXTPATH, DISPATCHER_SERVLET_NAME, new DispatcherServlet());
    }

}
