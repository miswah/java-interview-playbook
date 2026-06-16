package org.miswah;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Company implements Iterable<Employee>{
    private final List<Employee> employees = new ArrayList<>();
    @Override
    public Iterator<Employee> iterator() {
        return new CompanyIterator<Employee>();
    }

    public Iterator<Employee> hrIterator() {
        return new HrCompanyIterator<Employee>();
    }

    public Iterator<Employee> salesIterator() {
        return new SalesCompanyIterator<Employee>();
    }

    public Iterator<Employee> itIterator() {
        return new ItCompanyIterator<Employee>();
    }

    public void add(Employee emp) {
        employees.add(emp);
    }

    private class CompanyIterator<E> implements Iterator<Employee> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < employees.size();
        }

        @Override
        public Employee next() {
            if(!hasNext()){
                throw new NoSuchElementException("No more elements in the collection.");
            }
            return employees.get(currentIndex++);
        }
    }

    private class HrCompanyIterator<E> implements Iterator<Employee> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            while (currentIndex < employees.size()
                    && !employees.get(currentIndex).department().equals("HR")) {
                currentIndex++;
            }

            return currentIndex < employees.size();
        }

        @Override
        public Employee next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return employees.get(currentIndex++);
        }
    }

    private class ItCompanyIterator<E> implements Iterator<Employee> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            while (currentIndex < employees.size()
                    && !employees.get(currentIndex).department().equals("IT")) {
                currentIndex++;
            }

            return currentIndex < employees.size();
        }

        @Override
        public Employee next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return employees.get(currentIndex++);
        }
    }

    private class SalesCompanyIterator<E> implements Iterator<Employee> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            while (currentIndex < employees.size()
                    && !employees.get(currentIndex).department().equals("Sales")) {
                currentIndex++;
            }

            return currentIndex < employees.size();
        }

        @Override
        public Employee next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return employees.get(currentIndex++);
        }
    }
}
