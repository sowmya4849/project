package AI;

import java.util.Locale;
import java.util.Scanner;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class text_to_speech {

	public static void main(String[] args) throws Exception {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter a word");
    String x=sc.nextLine();
    //set property as kevin dictionary
    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
    //register engine
    Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
    //create a synthesizer
    Synthesizer s=Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
    //allocate synthesizer
    s.allocate();
    //resume synthesizer
    s.resume();
    //speaks the given text until queue is empty
    s.speakPlainText(x, null);
    s.waitEngineState(Synthesizer.QUEUE_EMPTY);
    //deallocate synthesizer
    s.deallocate();
    
	}

}
