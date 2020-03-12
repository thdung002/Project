const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const app = express();
const port = 8090;
var mysql = require('mysql');
var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'housetouring'
});
var saleid=0;
app.use(bodyParser.json());
app.use(cors());
app.use(express.urlencoded({ extended: true }));
connection.connect();

app.get('/user', (req, res) => {
    var data= {};
    var sql = "select * from sale";
    // jwt.destroy(token);
    saleid=0;
    var query = connection.query(sql, function(err, result)
    {
        if(err) throw err;
        else {data= result;
            res.send(data);
        }
    });
    console.log(query.sql);
    console.log(saleid);


});
app.post("/login",function(req,res){
    var dataform = req.body;
    var username=dataform.username;
    var password = dataform.password;
    saleid=0;
    var sql = "select * from users where Username='"+username+"' and Password='"+password+"' ";
    var query= connection.query(sql,function(err,result){
        console.log(result);
        if(err){
            res.json({success:0});
        }
        if(result.length>0 )
        {console.log("Login success");
            res.json({success:1});
            saleid = result[0].ID_Sale;
            connection.query(
                `UPDATE users SET last_login = now() WHERE ID_Sale = '${result[0].ID_Sale}'`
            );
        }
        else res.json({success:0});
    });
    console.log(query.sql);
});
app.get('/sale', (req, res) => {
    var data= {};
    var sql = "select * from sale where ID_Sale= '"+saleid+"'";
        var query = connection.query(sql, function(err, result)
        {
            if(err) throw err;
            else {data= result;
                res.send(data);
            }
    console.log(query.sql);
        });

});
app.post("/add",function(req,res){
    var dataform = req.body;
    var date = dataform.date;
    var plane = dataform.plan;
    var worktime = dataform.time;
    var sql = "INSERT INTO sale SET ?";
    var post ={ID_Sale:saleid,Date:date, Plane:plane,Worktime:worktime};
    var query = connection.query(sql,post,function (error, results) {
        if (error){
            res.json({success:0});
            throw error;
        }
        else{
            console.log("Number of worktime inserted: " + results.affectedRows);
            res.json({success:1});
        }

    });
    console.log(query.sql);

});
app.post("/user/add",function(req,res){
    var dataform = req.body;
    var name = dataform.name;
    var email = dataform.email;
    var phone = dataform.phone;
    var date = dataform.dateUserChoose;
    var plane = dataform.planeUserChoose;
    var worktime = dataform.timeUserChoose;
    var sql = "INSERT INTO booking SET ?";
    var post ={Full_name:name,Email:email,Phone:phone,Date:date, Plane:plane,Time:worktime};
    var query = connection.query(sql,post,function (error) {
        if (error){
            res.json({success:0});
        }
        else{
            console.log("Add success: ");
            res.json({success:1});
        }
    });
    console.log(query.sql);
});
app.get('/user/note', (req, res) => {
    var data= {};
    var sql = "select * from booking";
        var query = connection.query(sql, function (err, result) {
            if (err) throw err;
            
            else {
                data = result;
                res.send(data);
            }
        });
        console.log(query.sql);
        console.log(saleid);
});


// listen on the port
app.listen(port);
