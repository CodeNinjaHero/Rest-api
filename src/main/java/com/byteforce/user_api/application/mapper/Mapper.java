package com.byteforce.user_api.application.mapper;

import java.util.List;

public interface Mapper<T, I> {
	I mapTo(T t);

	T mapFrom(I i);
	List<I> mapToList(List<T> tList);
	List<T> mapFromList(List<I> iList);
}

