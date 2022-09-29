package RecourdSingers;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static Singers[] setSingersArr(int n){ // Введення інформації про співаків
        Scanner sc = new Scanner(System.in, "cp1251");
        Singers singer[] = new Singers[n];

        System.out.println("Введіть інформацію про співаків: ");
        for (int i = 0; i < singer.length; i++) {
            sc.nextLine();    //	очищення буфера
            singer[i] = new Singers();
            System.out.print("Прізвище " + (i + 1) + "-го співака => ");
            singer[i].name = sc.nextLine();
            System.out.print("Рейтинг " + (i + 1) + "-го співака => ");
            singer[i].rating = sc.nextDouble();
            System.out.print("Кількість випущенних альбомів " + (i + 1) + "-им співаком => ");
            singer[i].numberofalbums = sc.nextInt();
        }
        return singer;
    }

    public static void showArray(Singers [] singer){  // Виведення отриманої інформації
        for (int i = 0; i < singer.length; i++) {
            System.out.println("" + singer[i].name + "\t" + "- рейтинг виконавця " + singer[i].rating +
                    ", кількість випущенних альбомів " + singer[i].numberofalbums);
        }
    }

    public static int NomMax(Singers []singer){ // Виконавець з найбільшим рейтингом
        int nommax = 0;    //номер елемента для співака з максимальним рейтингом (початкове значення)
        double max = singer[nommax].rating; //максимальний рейтинг (початкове значення)
        for (int i = 0; i < singer.length; i++)
            if (singer[i].rating > max) {
                max = singer[i].rating;
                nommax = i;
            }
        return nommax;
    }

    public static void showSinger (Singers singer){ // Інформація про одного виконавця
        System.out.println("" + singer.name + "\t" + "- рейтинг виконавця " + singer.rating +
                ", кількість випущенних альбомів " + singer.numberofalbums);
    }
    public static Singers [] Bigger(Singers singer[]){ // Виконавець з к-тю випущенних альбомів > середньої
        double s = 0;    //сумарна к-ть альбомів
        for (int i = 0; i < singer.length; i++)
            s += singer[i].numberofalbums;
        double sr = s / singer.length;
        // середня к-ть альбомів
        System.out.println("Середня к-ть альбомів =" + sr);
        for (int i = 0; i < singer.length; i++) {
            if (singer[i].numberofalbums > sr)
                System.out.println(singer[i].name + "\t" + "- рейтинг виконавця " + singer[i].rating +
                        ", кількість випущенних альбомів " + singer[i].numberofalbums);
        }
        return singer;
    }
    public static Singers findForName(Singers singer[], String name){    // Пошук за назвою
        int nom = -1; //−1 – виконавець з шуканим прізвищем відсутній

        for (int i = 0; i < singer.length; i++)
            if (name.equalsIgnoreCase(singer[i].name))
                nom = i;

        if (nom!=-1) {
            return singer[nom];
        }
        else return null;
    }

    public static void sortABC(Singers []singer){  // Сортування масиву за алфавітом
        Singers[] singersAsc = singer.clone();

        Arrays.sort(singersAsc, Comparator.comparing(singers -> singers.name));
        for (int i = 0; i < singersAsc.length; i++) {
            System.out.println(singersAsc[i].name + "\tрейтинг виконавця " + singersAsc[i].rating +
                    "\tкількість випущенних альбомів " + singersAsc[i].numberofalbums);
        }
    }

    public static void sortRecerve(Singers []singer){  // Сортування масиву в протилежному порядку
        Singers[] singersDesc = singer.clone();

        Arrays.sort(singersDesc, (singers, t1) -> t1.name.compareToIgnoreCase(singers.name));
        for (int i = 0; i < singersDesc.length; i++) {
            System.out.println(singersDesc[i].name + "\tрейтинг виконавця " + singersDesc[i].rating +
                    "\tкількість випущенних альбомів " + singersDesc[i].numberofalbums);
        }
    }

    public static Singers Editing(Singers singer[]){ // Редагування та виведення інформації про пісню після редагування
        Scanner sc=new Scanner(System.in,"cp1251");

        for (int i = 0; i < singer.length; i++)
            System.out.printf("\n%d) %s ", i + 1, singer[i].name);
        System.out.println("\nВведіть співця (індекс) для редагування:");
        int selectedIndex = sc.nextInt() - 1;
        System.out.println("1) Прізвище");
        System.out.println("2) Рейтинг");
        System.out.println("3) Кількість випущенних альбомів");
        System.out.print("Введіть бажане поле (індекс) для редагування:");
        int selectedFieldIndex = sc.nextInt();
        Singers singerObject = singer[selectedIndex];
        switch (selectedFieldIndex) {
            case 1: {
                System.out.println("Прізвище: " + singerObject.name);
                System.out.println();
                System.out.print("Введіть нове прізвище: ");
                singerObject.name = sc.next().trim();
                break;
            }
            case 2: {
                System.out.println("Рейтинг: " + singerObject.rating);
                System.out.println();
                System.out.print("Введіть новий рейтинг: ");
                singerObject.rating = sc.nextDouble();
                break;
            }
            case 3: {
                System.out.println("Кількість випущенних альбомів: " + singerObject.numberofalbums);
                System.out.println();
                System.out.print("Введіть нову кількість випущених альбомів: ");
                singerObject.numberofalbums = sc.nextInt();
                break;
            }
        }
        singer[selectedIndex] = singerObject;
        System.out.println(" " + singerObject.name + " рейтинг " + singerObject.rating + ", кількість випущенних альбомів " + singerObject.numberofalbums);
        return singerObject;
    }

        public static void main(String[] args) { // Головний клас з методами
            Scanner sc=new Scanner(System.in,"cp1251");

            System.out.print("Введіть кількість співаків");
            int n=sc.nextInt(); // кількість країн
            Singers singer[]= setSingersArr(n); // введіть інформацію про країни

            System.out.println("\nХарактеристики співаків:");
            showArray(singer);

            int nommax = NomMax(singer);
            System.out.println("\nНайпопулярніший виконавець: ");
            showSinger (singer [nommax]);

            System.out.println("\nВиконавець з к-тю випущенних альбомів більше середньої");
            Singers [] larger = Bigger (singer);
            showArray(larger);

            System.out.println("Введіть прізвище шуканого виконавця=>");
            sc.nextLine();
            String sname=sc.nextLine();
            Singers sfind = findForName(singer, sname); if (sfind != null) {
                showSinger(sfind);
            }
            else System.out.println("Такого виконавця немає у списку.");

            System.out.println("\nВідсортований список за назвою в алфавітному порядку:");
            sortABC(singer);

            System.out.println("\nВідсортований список за назвою в протилежному порядку:");
            sortRecerve(singer);

            Editing(singer);

    }
}