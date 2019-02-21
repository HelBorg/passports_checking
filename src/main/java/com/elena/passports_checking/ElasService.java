package com.elena.passports_checking;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutionException;

public class ElasService {
    private TransportClient client;

    ElasService() throws IOException, ExecutionException, InterruptedException {

        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200));

        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("firstname", "Ivan")
                .field("secondname", "Ivanovich")
                .field("lastname", "Ivanov")
                .endObject();
        IndexResponse response = client.prepareIndex("passportchecking", "fullname", "1")
                .setSource(builder).get();
        System.out.println(response);

        GetResponse response1 = client.get(new GetRequest("passportchecking", "fullname", "1")).get();
        System.out.println(response1);
    }
}
