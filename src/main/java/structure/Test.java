package structure;

import entity.Participant;
import service.Printer;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<String> parts = List.of(
                "Гриша", "Антон", "Петя", "Аркаша"
//                , "Слава", "Виталик", "Семён", "Гена", "Степан",
//                "Рома", "Паша", "Андрей", "Никита", "Рустам", "Влад", "Клим", "Игорёк"

        );

        List<Participant> participants = List.of(
                new Participant(1, "Петя", "Иванов", 2012, 42, "Чижик"),
                new Participant(2, "Вася", "Петров", 2012, 41, "Мотылёк"),
                new Participant(3, "Игорь", "Васильев", 2012, 41, "Бабочки"),
                new Participant(4, "Лёша", "Сидоров", 2012, 40, "Травушка"),
                new Participant(8, "Аркадий", "Сазонов", 2012, 40, "Чижик"),
                new Participant(5, "Игнат", "Теренко", 2012, 41, "Травушка"),
                new Participant(6, "Артём", "Сазонов", 2012, 42, "Мотылёк"),
                new Participant(7, "Илья", "Ротор", 2012, 40, "Бабочки"),
                new Participant(9, "Павел", "Восходин", 2012, 41, "Котлетки")


                );


        OlympicGridSystem ps = new OlympicGridSystem(participants);
        List<Participant> pl = ps.create();

        Printer<Participant> printer = new Printer<>();
        printer.print(pl);

        System.out.println(pl);

    }
}
