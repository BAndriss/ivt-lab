package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore torpedoStoremock;

  @BeforeEach
  public void init(){
    torpedoStoremock = mock(TorpedoStore.class);
    this.ship = new GT4500(torpedoStoremock);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(torpedoStoremock.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(torpedoStoremock, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(torpedoStoremock.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(torpedoStoremock, times(2)).fire(1);
  }

}
