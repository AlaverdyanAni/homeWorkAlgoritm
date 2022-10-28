package org.example;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringListImpl implements StringList {
    private int size;
    private String[] items;

    public StringListImpl(int size) {
        items = new String[size];
    }

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(String item) {
        validateItem(item);
        return add(item);
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(int index, String item) {
        validateItem(item);
        validateIndex(index);
        if (size == items.length) {
            items = Arrays.copyOf(items, size + 1);
        }
        items[index] = item;
        size++;
        return items[index];
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        items[index] = item;
        return items[index];
    }


    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public String remove(String item) {
        validateItem(item);
        String[] copy = new String[items.length - 1];
        for (int i = 0, j = 0; i < items.length; i++) {
            if (items[i] != item) {
                copy[j] = items[i];
                j--;
            }
        }
        int index = indexOf(item);
        return items[index];
    }


    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public String remove(int index) {
        validateIndex(index);
        String[] copy = new String[items.length - 1];
        for (int i = 0, j = 0; i < items.length; i++) {
            if (i != index) {
                copy[j] = items[i];
                j--;
            }
        }
        return items[index];
    }


    // Проверка на существование элемента.
    // Вернуть true/false;
    @Override
    public boolean contains(String item) {
        for (String value : items)
            if (value.equals(item)) {
                return true;
            }
        return false;
    }


    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int indexOf(String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;

    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int lastIndexOf(String item) {
        for (int i = items.length; i > -1; i--) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;

    }


    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    @Override
    public String get(int index) {
        validateIndex(index);
        return items[index];
    }


    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    @Override
    public boolean equals(StringList otherList) {
        if (items.equals(otherList)) {
            return true;
        }
        return false;
    }


    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        return size;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    // Удалить все элементы из списка.
    @Override
    public void clear() {
        size = 0;
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    @Override
    public String[] toArray() {
        List<String> itemsList = new ArrayList<>();
        String[] itemsArray = new String[itemsList.size()];
        return itemsArray;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new MyIndexOfBoundException();
        }
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new MyNullPointerException();
        }
    }
}




