package movie;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MovieService.class})
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void returnsHighestGrossingMovie() throws Exception {
        Assert.assertEquals("Finding Dory", movieService.getTopGrossingMovie(2016));
        Assert.assertEquals("The Force Awakens", movieService.getTopGrossingMovie(2015));
        Assert.assertEquals("Guardians of the Galaxy", movieService.getTopGrossingMovie(2014));
        Assert.assertEquals("Iron Man 3", movieService.getTopGrossingMovie(2013));
        Assert.assertEquals("The Avengers", movieService.getTopGrossingMovie(2012));
        Assert.assertEquals("Harry Potter and the Deathly Hallows Part 2", movieService.getTopGrossingMovie(2011));
    }

    @Test
    public void returnsFallback() throws Exception {
        Assert.assertEquals("Beauty and the Beast", movieService.getTopGrossingMovie(1984));
    }
}
