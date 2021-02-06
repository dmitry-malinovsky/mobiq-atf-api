package context;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Primary
public class ScenarioContext {

    private static final Map<Key, Object> data = new HashMap<Key, Object>();

    public void saveData(Key key, Object value) {
        data.put(key, value);
    }

    public void getData(Key key) {
        data.get(key);
    }

    public void resetContext() {
        data.clear();
    }
}
