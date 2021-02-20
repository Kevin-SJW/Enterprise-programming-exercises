package GsonTest;

import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname GsonTest
 * @Description TODO
 * @Date 2020/9/1 0:32
 * @Created by Administrator
 */
public class GsonTest {
    public static void main(String[] args) {
        GsonTest gsonTest = new GsonTest();
        gsonTest.test1();
        System.out.println();
        gsonTest.test2();
    }

    public void test1() {
        String json = "[{\"id\":1,\"quantity\":2},{\"id\":3,\"quantity\":4}]";
        CustomizedObjectTypeAdapter adapter = new CustomizedObjectTypeAdapter();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<Map<String, Object>>() {
                }.getType(), adapter)
                .registerTypeAdapter(new TypeToken<List<Map<String, Object>>>() {
                }.getType(), adapter)
                .create();
        List<Map<String, Object>> ans = gson.fromJson(json, new TypeToken<List<Map<String, Object>>>() {
        }.getType());

        for (Map<String, Object> item : ans)
            System.out.println(item);

        String serialized = gson.toJson(ans);
        System.out.println(serialized);
    }

    public void test2() {
        String json = "[{\"id\":1,\"quantity\":2,\"name\":\"apple\"}, {\"id\":3,\"quantity\":4,\"name\":\"orange\"}]";

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(new TypeToken<Map<String, Object>>() {
        }.getType(), new MapDeserializerDoubleAsIntFix());

        Gson gson = gsonBuilder.create();
        List<Map<String, Object>> l = gson.fromJson(json, new TypeToken<List<Map<String, Object>>>() {
        }.getType());

        for (Map<String, Object> item : l)
            System.out.println(item);

        String serialized = gson.toJson(l);
        System.out.println(serialized);
    }
}


class CustomizedObjectTypeAdapter extends TypeAdapter<Object> {

    private final TypeAdapter<Object> delegate = new Gson().getAdapter(Object.class);

    @Override
    public void write(JsonWriter out, Object value) throws IOException {
        delegate.write(out, value);
    }

    @Override
    public Object read(JsonReader in) throws IOException {
        JsonToken token = in.peek();
        switch (token) {
            case BEGIN_ARRAY:
                List<Object> list = new ArrayList<Object>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(read(in));
                }
                in.endArray();
                return list;

            case BEGIN_OBJECT:
                Map<String, Object> map = new LinkedTreeMap<String, Object>();
                in.beginObject();
                while (in.hasNext()) {
                    map.put(in.nextName(), read(in));
                }
                in.endObject();
                return map;

            case STRING:
                return in.nextString();

            case NUMBER:
                //return in.nextDouble();
                String n = in.nextString();
                if (n.indexOf('.') != -1) {
                    return Double.parseDouble(n);
                }
                return Long.parseLong(n);

            case BOOLEAN:
                return in.nextBoolean();

            case NULL:
                in.nextNull();
                return null;

            default:
                throw new IllegalStateException();
        }
    }
}




class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return (Map<String, Object>) read(json);
    }

    public Object read(JsonElement in) {

        if (in.isJsonArray()) {
            List<Object> list = new ArrayList<Object>();
            JsonArray arr = in.getAsJsonArray();
            for (JsonElement anArr : arr) {
                list.add(read(anArr));
            }
            return list;
        } else if (in.isJsonObject()) {
            Map<String, Object> map = new LinkedTreeMap<String, Object>();
            JsonObject obj = in.getAsJsonObject();
            Set<Map.Entry<String, JsonElement>> entitySet = obj.entrySet();
            for (Map.Entry<String, JsonElement> entry : entitySet) {
                map.put(entry.getKey(), read(entry.getValue()));
            }
            return map;
        } else if (in.isJsonPrimitive()) {
            JsonPrimitive prim = in.getAsJsonPrimitive();
            if (prim.isBoolean()) {
                return prim.getAsBoolean();
            } else if (prim.isString()) {
                return prim.getAsString();
            } else if (prim.isNumber()) {

                Number num = prim.getAsNumber();
                // here you can handle double int/long values
                // and return any type you want
                // this solution will transform 3.0 float to long values
                if (Math.ceil(num.doubleValue()) == num.longValue())
                    return num.longValue();
                else {
                    return num.doubleValue();
                }
            }
        }
        return null;
    }
}
