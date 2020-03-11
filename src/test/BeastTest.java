package test;

import Beast.Beast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeastTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void after() {
        Beast.dispose();
    }

    @org.junit.jupiter.api.Test
    void getSensorUS() {
    }

    @org.junit.jupiter.api.Test
    void hasNoForwardMotion() {
    }

    @org.junit.jupiter.api.Test
    void grabAndLift() {
        Beast.getInstance().grabAndLift();
    }

}