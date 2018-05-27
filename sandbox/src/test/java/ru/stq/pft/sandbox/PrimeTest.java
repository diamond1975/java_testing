package ru.stq.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Primes;

import java.security.PublicKey;

public class PrimeTest {

  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrimeFast1(Integer.MAX_VALUE));
  }

  @Test
  public void testPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

  @Test
  public void testNonPrime() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE -2));
  }
}
