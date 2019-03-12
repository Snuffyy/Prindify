package ee.taltech.prindify.service.query;

import org.springframework.stereotype.Service;

@Service
public interface RequestQueryService<K, V> {

    V convert(K queryObject);
}
