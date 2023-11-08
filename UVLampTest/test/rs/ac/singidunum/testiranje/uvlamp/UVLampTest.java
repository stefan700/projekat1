package rs.ac.singidunum.testiranje.uvlamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UVLampTest {
    @Test
    public void UVLamp_ShouldCreateAnUVLampObjectInTurnedOffState() {
        UVLamp lamp = new UVLamp();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.OFF, lamp.getLedState()),
                () -> Assertions.assertEquals("", lamp.getScreenText())
        );

    }

    @Test
    public void switch1_ShouldChangeStateToStandBy_IfCurrentStateIsTurnedOff() {
        UVLamp lamp = new UVLamp();

        lamp.switch1();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("STBY", lamp.getScreenText())
        );
    }

    @Test
    public void switch1_ShouldChangeStateToTurnedOff_IfCurrentStateIsStandBy () {
        UVLamp lamp = new UVLamp();

        lamp.switch1();
        lamp.switch1();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.OFF, lamp.getLedState()),
                () -> Assertions.assertEquals("", lamp.getScreenText())
        );
    }

    @Test
    public void switch2_ShouldChangeStateToProgrammeSelection_IfCurrentStateIsStandBy() {
        UVLamp lamp = new UVLamp();

        lamp.switch1();
        lamp.switch2();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("PRSEL", lamp.getScreenText())
        );
    }

    @Test
    public void switch2_ShouldChangeStateToProgramme1Selected_IfCurrentStateIsProgrammeSelection() {
        UVLamp lamp = new UVLamp();

        lamp.switch1();
        lamp.switch2();
        lamp.switch2();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("PR1", lamp.getScreenText())
        );
    }

    @Test
    public void switch2_ShouldChangeStateToProgramme2Selected_IfCurrentStateIsProgramme1Selected() {
        UVLamp lamp = new UVLamp();

        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch2();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("PR2", lamp.getScreenText())
        );
    }

    @Test
    public void switch2_ShouldChangeStateToProgramme1Selected_IfCurrentStateIsProgramme2Selected() {
        UVLamp lamp = new UVLamp();

        lamp.switch1();
        lamp.switch2();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("PR1", lamp.getScreenText())
        );
    }
    @Test
    public void switch1_ShouldChangeStateToTurnedOff_IfCurrentStateSelected() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch1();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.OFF, lamp.getLedState()),
                () -> Assertions.assertEquals("", lamp.getScreenText())
        );
    }

    @Test
    public void switch1_ShouldChangeStateToTurnedOff_IfCurrentStateProgramme1Selected() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch1();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.OFF, lamp.getLedState()),
                () -> Assertions.assertEquals("", lamp.getScreenText())
        );
    }

    @Test
    public void switch1_ShouldChangeStateToTurnedOff_IfCurrentStateProgramme2Selected() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch2();
        lamp.switch1();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.OFF, lamp.getLedState()),
                () -> Assertions.assertEquals("", lamp.getScreenText())
        );
    }

    @Test
    public void switch3_ShouldChangeStateToStandBy_IfCurrentStateSelection() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch3();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("STBY", lamp.getScreenText())
        );
    }

    @Test
    public void switch3_ShouldChangeStateToSelection_IfCurrentStateProgramme1Selected() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch3();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.OFF, lamp.getLedState()),
                () -> Assertions.assertEquals("", lamp.getScreenText())
        );
    }

    @Test
    public void switch3_ShouldChangeStateToSelection_IfCurrentStateProgramme2Selected() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch2();
        lamp.switch3();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("PRSEL", lamp.getScreenText())
        );
    }

    @Test
    public void switch4_ShouldChangeStateToProgramme2Running_IfCurrentStateProgramme2Selected() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch2();
        lamp.switch4();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.OFF, lamp.getLedState()),
                () -> Assertions.assertEquals("", lamp.getScreenText())
        );
    }

    @Test
    public void internalEvent_ShouldChangeStateToStandBy_IfCurrentStateProgramme2Running_When30SecondsPass() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch2();
        lamp.switch4();


        try {
            Thread.sleep(31000);
        } catch (Exception e) { }

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("STBY", lamp.getScreenText())
        );
    }

    @Test
    public void internalEvent_ShouldNotChangeStateToStandBy_IfCurrentStateProgramme2Running_WhenLessThan30SecondsPass() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch2();
        lamp.switch4();

        try {
            Thread.sleep(29000);
        } catch (Exception e) { }

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.BLINKING, lamp.getLedState()),
                () -> Assertions.assertEquals("PR2", lamp.getScreenText())
        );
    }

    @Test
    public void switch3_ShouldChangeStateToSelection_IfCurrentStateIsProgramme2Running_WhenLessThan30SecondsPass() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch2();
        lamp.switch4();

        try {
            Thread.sleep(10000);
        } catch (Exception e) { }

        lamp.switch3();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("PRSEL", lamp.getScreenText())
        );
    }

    @Test
    public void switch4_ShouldChangeStateToProgramme1Running_IfCurrentStateProgramme1Selected() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();

        lamp.switch4();

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.BLINKING, lamp.getLedState()),
                () -> Assertions.assertEquals("PR1", lamp.getScreenText())
        );
    }

    @Test
    public void internalEvent_ShouldChangeStateToStandBy_IfCurrentStateProgramme1Running_When60SecondsPass() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch4();

        try {
            Thread.sleep(61000);
        } catch (Exception e) { }

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("STBY", lamp.getScreenText())
        );
    }

    @Test
    public void internalEvent_ShouldNotChangeStateToStandBy_IfCurrentStateProgramme1Running_WhenLessThan60SecondsPass() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch4();

        try {
            Thread.sleep(59000);
        } catch (Exception e) { }

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.BLINKING, lamp.getLedState()),
                () -> Assertions.assertEquals("PR2", lamp.getScreenText())
        );
    }
    @Test
    public void switch3_ShouldChangeStateToProgramme1Paused_IfCurrentStateProgramme1Running_WhenLessThan60SecondPass() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch4();

        try {
            Thread.sleep(9000);
        } catch (Exception e) { }

        lamp.switch3();

        try {
            Thread.sleep(1000);
        } catch (Exception e) { }

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.ON, lamp.getLedState()),
                () -> Assertions.assertEquals("PAUSE", lamp.getScreenText())
        );
    }
    @Test
    public void switch4_ShouldChangeStateToProgramme1Running_IfCurrentStateProgramme1Paused() {
        UVLamp lamp = new UVLamp();
        lamp.switch1();
        lamp.switch2();
        lamp.switch2();
        lamp.switch4();

        try {
            Thread.sleep(50000);
        } catch (Exception e) { }

        lamp.switch3();

        try {
            Thread.sleep(20000);
        } catch (Exception e) { }

        lamp.switch4();

        try {
            Thread.sleep(1000);
        } catch (Exception e) { }

        Assertions.assertAll(
                () -> Assertions.assertEquals(UVLamp.LED_STATE.BLINKING, lamp.getLedState()),
                () -> Assertions.assertEquals("PR1", lamp.getScreenText())
        );
    }
}
