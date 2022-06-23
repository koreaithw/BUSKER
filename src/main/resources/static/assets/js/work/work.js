console.log("Work Module...");

function workService = (function(){
   function getWorkKeywordList(param,callback, error) {
       let tag = param.tag || null;
       $.getJSON("/work/workList/"+param.tag)
   }

   return { getWorkKeywordList: getWorkKeywordList};
});