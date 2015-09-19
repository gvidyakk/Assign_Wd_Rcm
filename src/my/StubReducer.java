package my;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//public class StubReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

public class StubReducer extends Reducer<Text, Text, Text, Text> {

 @Override
  
//  public void reduce(Text key, Iterable<LongWritable> values, Context context)
  
    public void reduce(Text key, Iterable<Text> after_key_word, Context context)
    
      throws IOException, InterruptedException
  
  {
	 Text r_word; 
	 int i = 0;
	 
	  for(Text recom_word:after_key_word)
	  {
		  r_word = r_word + recom_word ;
	  }
	//  long sum = 0;
	//  for(LongWritable iw:values)
	//  {
	//	  sum += iw.get();
	//  }
	  
	  context.write(key, r_word);
  }
}
