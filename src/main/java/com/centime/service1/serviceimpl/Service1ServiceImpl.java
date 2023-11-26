package com.centime.service1.serviceimpl;

import com.centime.service1.dto.Customer;
import com.centime.service1.service.Service1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Service1ServiceImpl implements Service1Service {
    @Autowired
    RestTemplate restTemplate;
    @Value("${service2.name}")
    private String service2Name;
    @Value("${service3.name}")
    private String service3Name;

    @Override
    public String getConcatenatedString(Customer customer) {
        String response = "{\n";
        response += restTemplate.getForObject("http://" + service2Name + "/service-two/get-value", String.class);
        response += " "+restTemplate.postForObject("http://" + service3Name + "/service-three/concatenated-string", customer, String.class);
        response += "\n}";
        return response;

    }

}
