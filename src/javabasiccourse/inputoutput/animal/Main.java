package javabasiccourse.inputoutput.animal;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Animal[] animalM1 = { new Animal("Cat"), new Animal("Dog"), new Animal("Frog")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);
        for (Animal animal : animalM1) {
            oos.writeObject(animal);
        }
        oos.flush();
        oos.close();
        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
        System.out.println(animalM2.length);
        for (Animal animal : animalM2) {
            System.out.println(animal.getName());
        }
    }

    /*
    Метод, который из переданного массива байт восстановит массив объектов Animal.
    Массив байт устроен следующим образом. Сначала идет число типа int, записанное
    при помощи ObjectOutputStream.writeInt(size). Далее подряд записано указанное
    количество объектов типа Animal, сериализованных при помощи
    ObjectOutputStream.writeObject(animal).
    Если вдруг массив байт не является корректным представлением массива экземпляров
    Animal, то метод должен бросить исключение java.lang.IllegalArgumentException.
    */
    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = null;
        Integer numAnimals;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))){
            numAnimals = objectInputStream.readInt();
            animals = new Animal[numAnimals];
            for (int i = 0; i < numAnimals; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }
        }
        catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        catch (ClassCastException e) {
            throw new IllegalArgumentException(e);
        }
        return animals;
    }
}
