package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringListImpl implements StringList {
    private int size;
    private String[] items;

    public StringListImpl() {
        items = new String[10];
    }

    public StringListImpl(int initSize) {
        items = new String[initSize];
    }

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        items[size++] = item;
        return item;
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
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            items[size++] = item;
            return item;
        }
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return item;
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
        return item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = items[index];
        if (index != size) {
            System.arraycopy(items, index + 1, items, index, size - index);
        }
        size--;
        return item;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
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
        return Arrays.equals(this.toArray(), otherList.toArray());
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
        return size == 0;
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
        return Arrays.copyOf(items, size);
    }
    private void validateSize() {
        if (size == items.length) {
            throw new ItemsIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new NullItemException();
        }
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; i < size; i++) {
            stringBuilder.append(items[i]);
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
            return stringBuilder.append(']').toString();
    }
}






