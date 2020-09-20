import org.junit.jupiter.api.Test;
import tasks.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    Task1 task1 = new Task1();
    Task2 task2 = new Task2();
    Task10 task10 = new Task10();
    Task13 task13 = new Task13();

    @Test
    public void testReadFile(){
        List<String> expected = Arrays.asList(
                "From fairest creatures we desire increase,",
                "That thereby beauty's rose might never die,",
                "But as the riper should by time decease,",
                "His tender heir might bear his memory:",
                "But thou contracted to thine own bright eyes,",
                "Feed'st thy light's flame with self-substantial fuel,",
                "Making a famine where abundance lies,",
                "Thy self thy foe, to thy sweet self too cruel:",
                "Thou that art now the world's fresh ornament,",
                "And only herald to the gaudy spring,",
                "Within thine own bud buriest thy content,",
                "And, tender churl, mak'st waste in niggarding:",
                "   Pity the world, or else this glutton be,",
                "   To eat the world's due, by the grave and thee.");
        List<String> result = task1.readFile();
        assertLinesMatch(expected,result);
    }

    @Test
    public void testWriteFile(){
        task1.writeFile(task1.readFile());
        List<String> expected = Arrays.asList(
                "From fairest creatures we desire increase,",
                "That thereby beauty's rose might never die,",
                "But as the riper should by time decease,",
                "His tender heir might bear his memory:",
                "But thou contracted to thine own bright eyes,",
                "Feed'st thy light's flame with self-substantial fuel,",
                "Making a famine where abundance lies,",
                "Thy self thy foe, to thy sweet self too cruel:",
                "Thou that art now the world's fresh ornament,",
                "And only herald to the gaudy spring,",
                "Within thine own bud buriest thy content,",
                "And, tender churl, mak'st waste in niggarding:",
                "   Pity the world, or else this glutton be,",
                "   To eat the world's due, by the grave and thee.");
        List<String> result = task1.readFile();
        assertLinesMatch(expected,result);
    }

    @Test
    public void testProcessNumber() {
        int expected = 321;
        int result = task2.processNumber(123);
        assertEquals(expected, result);
    }

    @Test
    public void testUniqueIntLast(){
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3));
        int expected = 6;
        int result = task10.uniqueIntLast(set);
        assertEquals(expected,result);
    }

    @Test
    public void testElementsExchange(){
        List<Integer> testList = Arrays.asList(-1,3,5,0,-6,8,9);
        List<Integer> expected = Arrays.asList(9,3,5,0,8,-6,-1);
        task13.elementsExchange(testList);
        assertIterableEquals(testList,expected);
    }
}