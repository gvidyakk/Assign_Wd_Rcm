package my;
import java.io.IOException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StubMapper extends Mapper<Object, Text, Text, Text> {

  @Override
  public void map(Object key, Text value, Context context)
      throws IOException, InterruptedException {
    /*
     * TODO implement
     */
	  String[] words = value.toString().split("[ \t]+");
	  String Prev_word = "none";
	  for(String word:words)
		  
	  { 
		  if( Prev_word == "none")
		  		{ 
			  		Prev_word = word ;
			  		
			  	}
		  else
		  		{  
			  		System.out.println("ddd");
			  		System.err.println("erorr");
			  		context.write(new Text(Prev_word), new Text(word));
			  		Prev_word = word;
		  		}
	  }
  }
}
