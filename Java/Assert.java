//CS_2110@Cornell 
//use macro to do assetion debug
#ifdef DEBUG
  #define CHECK(b,str){
    if(b){}
    else{ 
      report(str);
      assert(false);
    }
  }
#else #define CHECK(b,str)
#endif
