package io.quarkus.test.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class HazelcastServerTestResource {

    @Inject
    HazelcastInstance hazelcastClient;
	
	public void connect(String key, String value) {
        hazelcastClient.<String, String>getMap("TEST").put(key,value);
    }
	
	@Scheduled(every = "5s")
    void testConnect() {
		connect("test","test");
    }
}
