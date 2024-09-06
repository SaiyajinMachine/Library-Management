package io.andrepinho.library.converter;

import java.util.List;

public interface Converter<T, R> {
    List<T> convertList(List<R> dataList);
    T convert(R data);
}
