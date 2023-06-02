package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore torpedoStoremock1;
  private TorpedoStore torpedoStoremock2;


  @BeforeEach
  public void init(){
    torpedoStoremock1 = mock(TorpedoStore.class);
    torpedoStoremock2 = mock(TorpedoStore.class);

    this.ship = new GT4500(torpedoStoremock1, torpedoStoremock2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(torpedoStoremock1.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(torpedoStoremock1, times(1)).fire(1);
  }
  @Test
  public void fireTorpedo_Single_Failer(){
    // Arrange
    when(torpedoStoremock1.fire(1)).thenReturn(false);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(false, result);
    verify(torpedoStoremock1, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(torpedoStoremock1.fire(1)).thenReturn(true);
    when(torpedoStoremock2.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(torpedoStoremock1, times(1)).fire(1);
    verify(torpedoStoremock2, times(1)).fire(1);
  }
  @Test
  public void fireTorpedo_All_Failer(){
    // Arrange
    when(torpedoStoremock1.fire(1)).thenReturn(false);
    when(torpedoStoremock2.fire(1)).thenReturn(false);    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(false, result);
    verify(torpedoStoremock1, times(1)).fire(1);
    verify(torpedoStoremock2, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_Single_Succes_First_IsEmpty(){
    // Arrange
    when(torpedoStoremock1.isEmpty()).thenReturn(true);
    when(torpedoStoremock2.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(torpedoStoremock1, times(1)).isEmpty();
    verify(torpedoStoremock2, times(1)).fire(1);
  }
  @Test
  public void fireTorpedo_Single_Succes_Second_IsEmpty(){
    // Arrange
    when(torpedoStoremock2.isEmpty()).thenReturn(true);
    when(torpedoStoremock1.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(torpedoStoremock1, times(1)).fire(1);
  }
  @Test
  public void fireTorpedo_Single_Failed_Boot_IsEmpty(){
    // Arrange
    when(torpedoStoremock1.isEmpty()).thenReturn(true);
    when(torpedoStoremock2.isEmpty()).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(false, result);
    verify(torpedoStoremock1, times(1)).isEmpty();
    verify(torpedoStoremock2, times(1)).isEmpty();
  }
}
