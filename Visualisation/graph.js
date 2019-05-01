/*
  List<Article> content must me initialise;
  Boolean articleView must be set to true if view article is set up
*/
$(document).ready(function() {
    //content could be initialise with getData
    //Untested fonction
    //var content = 'article.json';
    //var url = 'http://localhost:9000/article.json';
    var url = 'article.json';
    //var url='http://mdl-std02.info.fundp.ac.be:8181/MdlGroupe2-test/api/AdvancedSearchJson';
    var articleView = true;
    //keywords is the list of args to pass to url
    // Structure : data: {"first": "Manu","Last":"Sharma"},

    var json = "";
    $.ajax({
        'async': false,
        'global': false,
        'url': url,
        'dataType': "json",
        'success': function (data) {
            json = data;
        }
    });

    //document.getElementById("container").innerHTML = typeOfGraph(json,articleView);
    typeOfGraph(json,articleView);
});

/*
    TODO
*/
function typeOfGraph(json,articleView){

  if (articleView) {
    console.log("articleView");
    parseJsonForArticle(json);
  }else{
    console.log("authorView");
    parseJsonForAuthor(json);
  }
}

/*
  -PRE  :
          Structure List<Article> [ article 1, article2,...,articleN]
          Structure Article {élement1,élement2,...}
  -POST :
          Return New JSON's Structure
            {nodes : [{"id":"", "label":""},...], edges : [ {"id":"" , "source":"", "target":""},...]}
*/
function parseJsonForArticle (json){
  //initialise
  var articleNodes = "";
  var articleEdges = "";
  var articleContent= "";
  var i = 0;

  console.log("ParseJson");
  for ( var article = 0 ; article < json.length ; article++ ){
    articleNodes = articleNodes+'{"id":'+ json[article].id + ',"label":"' + json[article].title + '","x":'+Math.random()+',"y":'+Math.random()+',"size": 1,"linktoArticle":" Lien vers l\'article:'+json[article].id+'"},';

    for( var ref = 0 ; ref < json[article].bibliographie.length ; ref++ ){
      articleEdges = articleEdges+'{"id":' + i + ',"source":' + json[article].id + ',"target":' + json[article].bibliographie[ref].ref +',"type":"arrow"},';
      i++;
    }
  }

  //retire la dernière virgule
  articleNodes = articleNodes.slice(0, -1);
  articleEdges = articleEdges.slice(0,-1);
  articleContent = '{"nodes":['+articleNodes+'],"edges":['+articleEdges+']}';


  displayGraph (articleContent);
}

/*
  -PRE  :
          Structure List<Article> [ article1, article2,...,articleN]
          Structure Article {élement1,élement2,...}
  -POST :
          Return New JSON's Structure
            {nodes : [{id, size, label},...], edges : [ {id , source, target},...]}
*/
function parseJsonForAuthor (json){
  //initialise
  var authorNodes = "";
  var authorEdges = "";
  var authorContent = "";
  var i=0;
  var j=0;

  //For loop on List<Article>
  for(var article = 0 ; article <json.length ; article++){
    //For loop on [Author] Node creation for each author
    for(var author = 0; author < json[article].author[author].length ; author++){
      //+Rajout if author déjà present...
      authorNodes = authorNodes+'{"id":'+i+',"label":"'+json[article].author[author]+'","x":'+Math.random()+',"y":'+Math.random()+',"size": 1},';
      i++;
      //TODO
    }
  }
  authorNodes = authorNodes.slice(0, -1);
  authorEdges = authorEdges.slice(0,-1);
  authorContent = '{"nodes":['+authorNodes+'],"edges":['+authorEdges+']}';

  displayGraph (authorContent);
}

/*
  Function Test must be suppress
*/
function displayJSON(content){
  document.getElementById("container").innerHTML = content
}

/*
  -PRE  :
          Get A JSON with a Structure like : {nodes : [{id, size, label},...], edges : [ {id , source, target},...]}
  -POST :
        displayGraph on screen
*/
function displayGraph (content){
  console.log("displaygraph")
  console.log(content)
  json = JSON.parse(content);

    //Add method for anomation
    sigma.classes.graph.addMethod('neighbors', function(nodeId) {
      var k,
          neighbors = {},
          index = this.outNeighborsIndex[nodeId] || {};

      for (k in index)
        neighbors[k] = this.nodesIndex[k];

      return neighbors;
    });

    s = new sigma(
    {
        renderer: {
          container:container,
          container: document.getElementById('container'),
          type: 'canvas'
        },
        settings: {
          minEdgeSize:2,
          maxEdgeSize:10,
          maxNodeSize:5,
          sideMargin:10,
          minArrowSize:5,
          drawLabels: false,
          animationsTime: 2000
          //defaultNodeColor: '#ec5148'

          //minNodeSize: 8,
          //maxNodeSize: 16
        }
    });
    // Load the graph in sigma
    console.log("read");
    s.graph.read(json)
    console.log("read done");
    //Set position
    s.startForceAtlas2();
    window.setTimeout(function() {s.killForceAtlas2()}, 1000);

    //Add Color animation based on neighbors
    s.bind('overNode outNode clickNode doubleClickNode rightClickNode', function(e) {
      var nodeId = e.data.node.id,
            toKeep = s.graph.neighbors(nodeId);
        toKeep[nodeId] = e.data.node;

        s.graph.nodes().forEach(function(n) {
          if (toKeep[n.id])
            n.color = n.originalColor;
          else
            n.color = '#eee';
        });

        s.graph.edges().forEach(function(e) {
          if (toKeep[e.source] && toKeep[e.target])
            e.color = e.originalColor;
          else
            e.color = '#eee';
        });
    });

    s.bind('clickNode',function(e){
      clicknode = e.data.node;
      var left = e['data']['node']['renderer1:x'];
      var top = e['data']['node']['renderer1:y'];
      //TODO modifies html
      $('.popover').html("<a href=\"https://www.w3schools.com\">clicknode.linktoArticle</a>");
      var theHeight = $('.popover').height();
      var theWidth = $('.popover').width();
      $('.popover').css('left', (left)-30 -theWidth+ 'px');
      $('.popover').css('top', (top-(theHeight/2))+35 + 'px');
      $('.popover').show();

      s.refresh();
    });

    s.bind('clickStage', function(e) {
      s.graph.nodes().forEach(function(n) {
        n.color = n.originalColor;
      });

      s.graph.edges().forEach(function(e) {
        e.color = e.originalColor;
      });
      //cache le pop up
      $('.popover').hide()
      // Same as in the previous event:
      s.refresh();
    });

    //Add info on the node
    //https://github.com/jacomyal/sigma.js/issues/413
    //https://www.bsimard.com/2018/04/25/graph-viz-with-sigmajs.html


    //s.bind('overNode outNode clickNode doubleClickNode rightClickNode', function(e) {
    //  console.log(e.type, e.data.node.label, e.data.captor);
    //});

    s.refresh();
    console.log("done");
}
