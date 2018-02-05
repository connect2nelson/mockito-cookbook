package fun.abm.com.mockitocookbook.spyDemo;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class HashMapWrapper {

    private HashMap<String, String> hashMap = new HashMap<>();

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    void put(String key, String value) {
        this.hashMap.put(key, value);
    }

    String get(String key) {
        return this.hashMap.get(key);
    }

}
