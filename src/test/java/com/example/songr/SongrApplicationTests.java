package com.example.songr;

import com.example.songr.data.album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
<<<<<<< HEAD
	void albumClassTest() {
//		album Sample=new album("never die","john",1000,190,"www.google.com/album1");
//        String expectedArtist="john";
//		String actualArtist=Sample.getArtist();
//		assertEquals(expectedArtist,actualArtist);
//
//		int expectedLength=400;
//		Sample.setLength(expectedLength);
//		int actualLength=Sample.getLength();
//		assertEquals(expectedLength,actualLength);
=======
	void albumClassTest() throws IOException {
		album Sample=new album("never die","john",1000,190,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxBHJVHKOHqhFYt8DZ-V4RD62D7NNE99D-Eg&usqp=CAU");
        String expectedArtist="john";
		String actualArtist=Sample.getArtist();
		assertEquals(expectedArtist,actualArtist);

		int expectedLength=400;
		Sample.setLength(expectedLength);
		int actualLength=Sample.getLength();
		assertEquals(expectedLength,actualLength);
>>>>>>> 6ac6d6004f6552b1cc77daf0fb2363fadd6921ca


	}

}
