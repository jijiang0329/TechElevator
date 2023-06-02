package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {
    @Test
    public void test_have_party1() {
        CigarParty party = new CigarParty();
        boolean result = party.haveParty(30, false);
        Assert.assertEquals(false, result);
    }
    @Test
    public void test_have_party2() {
        CigarParty party = new CigarParty();
        boolean result = party.haveParty(50, false);
        Assert.assertEquals(true, result);
    }
    @Test
    public void test_have_party3() {
        CigarParty party = new CigarParty();
        boolean result = party.haveParty(70, true);
        Assert.assertEquals(true, result);
    }
}
