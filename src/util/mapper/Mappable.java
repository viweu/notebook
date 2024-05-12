package util.mapper;

public interface Mappable<E, T> {
    E toInput(T t);
    T toOutput(E e);
}