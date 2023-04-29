package edu.psu.ist.model;

/**
 * exports the abstract method produce
 * functions as a generator of elements (type U)
 * is implemented with a lambda expression
 * @param <U> the type of entries that are produced
 */
public interface IProducer<U> {
    U produce();
}
