package MisthyxLabs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static MisthyxLabs.Main.isLeap;
import static org.junit.jupiter.api.Assertions.*;

public class MainTests {

   @ParameterizedTest
   //@CsvSource (value = "1804, true")
   @CsvFileSource (resources = "/isLeapArguments.csv")
   public void isLeapTest(int year, boolean expected) {
      assertEquals(expected, isLeap(year));
   }





}