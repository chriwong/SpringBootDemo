package com.chriwong.dataannotationsdemo.client;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.Data;

import java.io.IOException;

@Data
public class Person {

    private Translation knownName;
    private Translation givenName;
    private Translation familyName;
    private Translation fullName;
    private String filename;
    private String penname;
    private GenderEnum gender = null;
    private Event birth = null;
    private Event death = null;

    @JsonAdapter(GenderEnum.Adapter.class)
    public enum GenderEnum {
        FEMALE("female"),

        MALE("male");

        private String value;

        GenderEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static GenderEnum fromValue(String text) {
            for (GenderEnum b : GenderEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<GenderEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final GenderEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public GenderEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return GenderEnum.fromValue(String.valueOf(value));
            }
        }
    }

}

