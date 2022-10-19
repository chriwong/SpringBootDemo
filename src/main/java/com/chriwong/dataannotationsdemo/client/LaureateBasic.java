package com.chriwong.dataannotationsdemo.client;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.Data;

import java.io.IOException;
import java.util.List;

@Data
public class LaureateBasic {

    private Integer id;
    private Translation name;
    private PortionEnum portion = PortionEnum._1;
    private SortOrderEnum sortOrder = SortOrderEnum._1;
    private Translation motivation;
    private List<ItemLinks> links;

    @JsonAdapter(PortionEnum.Adapter.class)
    public enum PortionEnum {
        _1("1"),

        _1_2("1/2"),

        _1_3("1/3"),

        _1_4("1/4");

        private String value;

        PortionEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static PortionEnum fromValue(String text) {
            for (PortionEnum b : PortionEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<PortionEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final PortionEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public PortionEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return PortionEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @JsonAdapter(SortOrderEnum.Adapter.class)
    public enum SortOrderEnum {
        _1("1"),

        _2("2"),

        _3("3");

        private String value;

        SortOrderEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SortOrderEnum fromValue(String text) {
            for (SortOrderEnum b : SortOrderEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<SortOrderEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SortOrderEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SortOrderEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return SortOrderEnum.fromValue(String.valueOf(value));
            }
        }
    }

}