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
                new Participant(6, "Артём", "Сазонов", 2012, 42, "Мотылёк"),
                new Participant(3, "Игорь", "Васильев", 2012, 41, "Бабочки"),
                new Participant(4, "Лёша", "Сидоров", 2012, 40, "Травушка"),
                new Participant(8, "Аркадий", "Сазонов", 2012, 40, "Чижик"),
                new Participant(5, "Игнат", "Теренко", 2012, 41, "Жучки"),
                new Participant(7, "Илья", "Ротор", 2012, 40, "Ги"),
//                new Participant(9, "Павел", "Восходин", 2012, 41, "Татер"),
//                new Participant(11, "Артём", "Сазонов", 2012, 42, "Ороро"),
//                new Participant(12, "Аркадий", "Сазонов", 2012, 40, "Василёк"),
//                new Participant(13, "Петя", "Иванов", 2012, 42, "Ороро"),
//                new Participant(14, "Вася", "Петров", 2012, 41, "Ги"),
//                new Participant(15, "Артём", "Сазонов", 2012, 42, "Мотылёк"),
//                new Participant(16, "Игорь", "Васильев", 2012, 41, "Бабочки"),
//                new Participant(17, "Лёша", "Сидоров", 2012, 40, "Травушка"),
                new Participant(10, "Антон", "Ульянов", 2012, 40, "Татер")
                );


//        OlympicGridSystem ps = new OlympicGridSystem(gs.prepare(participants));
//        List<Participant> pl = ps.create();

        OlympicGridSystem_v2 ps = new OlympicGridSystem_v2(participants);
        List<Participant> pl = ps.recursiveCreate(participants);

        Printer<Participant> printer = new Printer<>();
        printer.print(pl);

        System.out.println(pl);

    }
}
