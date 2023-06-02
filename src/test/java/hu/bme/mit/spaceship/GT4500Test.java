package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore torpedoStore1mock;
    private TorpedoStore torpedoStore2mock;

  @BeforeEach
  public void init(){
    torpedoStore1mock = mock(TorpedoStore.class);
    torpedoStore2mock = mock(TorpedoStore.class);
    this.ship = new GT4500(torpedoStore1mock, torpedoStore2mock);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(false, result);
  }

}
