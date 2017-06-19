package movie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MovieService.class})
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void returnsHighestGrossingMovie() throws Exception {
        assertEquals("Finding Dory", movieService.getTopGrossingMovie(2016));
        assertEquals("The Force Awakens", movieService.getTopGrossingMovie(2015));
        assertEquals("Guardians of the Galaxy", movieService.getTopGrossingMovie(2014));
        assertEquals("Iron Man 3", movieService.getTopGrossingMovie(2013));
        assertEquals("The Avengers", movieService.getTopGrossingMovie(2012));
        assertEquals("Harry Potter and the Deathly Hallows Part 2", movieService.getTopGrossingMovie(2011));
    }

    @Test
    public void returnsFallback() throws Exception {
        assertEquals("Beauty and the Beast", movieService.getTopGrossingMovie(1984));
    }
}
