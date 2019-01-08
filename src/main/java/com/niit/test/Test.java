package com.niit.test;
import com.niit.POJO.*;
import com.niit.POJO.Item;
import com.niit.Utils.HibernateUtils;
import com.niit.dao.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        ItemType itemType=new ItemType(1,"Arts");
        ItemType itemType2=new ItemType(2,"Food & Craft");
        ItemType itemType3=new ItemType(3,"Comics & Illustration");
        ItemType itemType4=new ItemType(4,"Films");
        ItemType itemType5=new ItemType(5,"Design & Tech");
        session.save(itemType);
        session.save(itemType2);
        session.save(itemType3);
        session.save(itemType4);
        session.save(itemType5);


        Country_Currency country_currency=new Country_Currency("China","CNY");
        Country_Currency country_currency2=new Country_Currency("USA","USD");
        Country_Currency country_currency3=new Country_Currency("Korea","KWD");

        session.save(country_currency);
        session.save(country_currency2);
        session.save(country_currency3);

        //1.添加用户基本信息
        User user1=new User("China","370203199610097917", DigestUtils.md5Hex("961009xy"),"Henry_Fordham","15269218298",0.00);
        User user2=new User("Korea","370203199610097918", DigestUtils.md5Hex("961009xy"),"Davic_Hsu","17865421703",0.00);
        User user3=new User("China","370203199612036812", DigestUtils.md5Hex("123456"),"Kane Zeang","17863956527",777777.00);

        session.save(user1);
        session.save(user2);
        session.save(user3);


        Investor investor1=new Investor("370203199610097917",10);
        Investor investor2=new Investor("370203199610097918",10);
        Investor investor3=new Investor("370203199612036812",10);

        session.save(investor1);
        session.save(investor2);
        session.save(investor3);

        //2.添加融资人
        Financier financier1 = new Financier("370203199610097917");
        Financier financier2 = new Financier("370203199610097918");
        Financier financier3 = new Financier("370203199612036812");
        session.save(financier1);
        session.save(financier2);
        session.save(financier3);



        //3.添加融资项目
        // 3.1  1号融资人添加了10个项目
        Set<Item> carSet = new HashSet<>();


        Item item1 = new Item(10,"ThermoChrome","Thermochromic resin is a 3D-printable resin that changes color in response to different temperatures.",1,930.0,330.0,1,new Date(2015-1900,4,2),"New discoveries are often born from coincidences. We initially created our thermochromic resin to solve a medical problem but quickly realized it has much wider potential than we first envisioned. Now, with your help, we aim to develop new functional resins for 3D printing that can be used by designers, creators, engineers, and 3D printing enthusiasts. This new resin can change color according to temperature and therefore has many potential applications in areas such as food safety, saving energy, and monitoring temperature. But we are more than a resin manufacturer—we can also 3D print a variety of artful objects. Currently, we are developing a smartphone app than can display the resin's temperature.\n" +
                "\n" +
                "The resin is designed to interact with the surrounding environment. We have made three primary products so far:" +
                "Thank you for your invaluable support and believing in us!\n" +
                "\n" +
                "We really appreciate your support in exploring the potential application of this new type of resin with us and sharing our project with your family and friends! If you have any questions, please kindly check out the FAQ section, and if unfortunately there is not an answer to your question or if you would like to provide any feedback, you are most welcome to post a comment or contact us. We look forward to hearing from you!");
        Item item2 = new Item(20,"The Bottery","A Robotic Ceramic Workshop: Combining cutting-edge technology with humankind’s oldest craft traditions.",2,9045.0,9045.0,1,new Date(2016-1900,12,21),"Our goal is to create a design manufactory for ceramic innovation using state-of-the-art technology. We believe in the potential of 3D printed ceramics to allow anyone to make customized design-oriented functional pottery. 3D printing ceramics requires highly specialized spaces, tools, and know-how, which we have spent years cultivating. Now, we want to share our expertise to enable and empower others. With your help, the Bottery will do this in three ways:\n" +
                "\n" +
                "Storefront and Workshop Space\n" +
                "\n" +
                "The Bottery will be a space where we host educational workshops in 3D printing clay for individuals and companies, making it possible for anyone to learn how to produce technological, functional, or sculptural ceramics. No matter what your expertise in 3D printing or ceramics is (or lack thereof!), our workshops will give you the tools to produce beautiful customized  ceramics using only quality, environmentally safe clays and glazes.\n" +
                "\n" +
                "Potterware\n" +
                "\n" +
                "Potterware™\n" +
                "Potterware™\n" +
                "Not a professional designer, or can’t make it to Oakland? It’s ok, because we are developing an easy-to-use app, so that no matter where you are, or your knowledge of ceramics or 3D printing, you can design your own functional ceramics. Anyone who has an idea for a single ceramic object or a whole line of ceramic pieces can use our services to bring their ideas to life.\n" +
                "\n" +
                "Bring the Bottery Home\n" +
                "\n" +
                "Potterbot\n" +
                "Potterbot\n" +
                "The Bottery has teamed up with 3D Potter to offer a line of ceramic 3D printers so that you too can bring our technology home with you and create your own robotic pottery in your home, studio, or company. Our printers use full-body clay, allowing anyone to create large, high-quality, ceramic work using any clay you wish, from terracotta, earthenware, or porcelain. It’s really up to you.\n" +
                "\n" +
                "Join the Bottery community and make custom ceramic designs no matter where you are in the world!\n" +
                "\n" +
                "3D-printed Ceramics\n" +
                "\n" +
                "Clay is a really exciting material—it’s been used for 30,000 years for its strength, beauty, and sustainability. Coiled clay is one of the earliest forms of making pottery, and now, with 3D printing, perhaps the most advanced. \n" +
                "\n" +
                "[insert coiled clay historic image here]\n" +
                "\n" +
                "Clay is a safe, non-toxic, sustainable, and beautiful material. There is no limit to what you can do with it—functional objects, sculpture, architecture, you name it!\n" +
                "\n" +
                "3D printed architectural tiles\n" +
                "3D printed architectural tiles\n" +
                "In comparison to traditional methods, 3D-printing is incredibly fast and opens the fields to brand-new shapes and textures. Digital design allows for both efficient mass production of identical objects, such as bricks or shingles, and customization and fine control of intricate details for stunning art pieces.\n" +
                "\n" +
                "glazed and fired ceramic vessel\n" +
                "glazed and fired ceramic vessel\n" +
                "Emerging Objects\n" +
                "\n" +
                "3D Printed Cabin with ceramic cladding\n" +
                "3D Printed Cabin with ceramic cladding\n" +
                "Emerging Objects is an independent, creatively driven, 3D Printing MAKE-tank specializing in innovations in 3D printing materials for architecture, building components, environments and products, co-founded by Ronald Rael and Virginia San Fratello of Emerging Objects. In recent years, we have been hard at work at home and abroad printing custom functional ceramics and both object and architectural scale. \n" +
                "\n" +
                "\n" +
                "Virginia San Fratello \n" +
                "\n" +
                "Virginia is an architect, artist, and educator. She teaches design at San Jose State University and believes design for the 21st century absolutely must incorporate sustainable methods and take advantage of local and ecological material resources, and works with designers and manufacturers to bring sustainable products to market. She has been awarded the International Interior Design Educator of the Year Award as well as Metropolis Magazine’s Next Generation Design Award. \n" +
                "\n" +
                "Ronald Rael \n" +
                "\n" +
                "Ronald Rael is an artist and professor of architecture at the University of California Berkeley where he runs the printFARM. He has always been interested in clay, having designed and constructed several building in adobe and authored the book Earth Architecture (Princeton Architectural Press). In 2014 Ronald and Virginia were named an Emerging Voice by The Architectural League of New York.\n" +
                "\n" +
                "Ronald Rael and Virginia San Fratello\n" +
                "Ronald Rael and Virginia San Fratello\n" +
                "Rewards \n" +
                "\n" +
                "Pledge $25 and more\n" +
                "\n" +
                "Small 3D printed ceramic espresso cup! Lovely and tactile!\n" +
                "\n" +
                "Pledge $50 or more");
        Item item3 = new Item(30,"Tinkamo","Teach your kids 5~12 to start coding with wireless, AI-powered, programmable building blocks. Encourage them to create.",1,42179.0,42179.0,1,new Date(2015-1900,4,2),"Designed for children ages 5-12, Tinkamo brings ideas to life. Compact, wireless, and easy-to-snap, all it takes is your imagination and some simple drag and drop coding.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Tinkamo wireless smart building blocks are so smart that they have eyes to see, ears to hear, legs to move and even brains to think. They can be built on each other and can connect with the app. They are as cute as candies and they work as easy as 1-2-3.\n" +
                "\n" +
                "1) Build. Easy to build on each other, with LEGO® or with cardboard.\n" +
                "2) Code. Connect wirelessly. Drag’n’drop to code. See instant results.\n" +
                "3) Go. Play in the real world. Solve real problems. Have real fun.\n" +
                "\n" +
                "\n" +
                "\n" +
                "With Tinkamo wireless smart building blocks, kids can bring all their crazy ideas to life. They are also compatible with LEGO® and they can be built on each other.\n" +
                "\n" +
                "Play Games and Learn to Code!\n" +
                "The game map provides mind-twisting quests to practice your logic and math. You can also challenge your friends in multiplayer games.\n" +
                "\n" +
                "\n" +
                "Revive Your LEGO®\n" +
                "\n" +
                "Have LEGO® collections at home? Let’s bring them to life! All it takes is 15 minutes and endless imagination.\n" +
                "\n" +
                "\n" +
                "Tink Your Own Creation!\n" +
                "\n" +
                "Kids think differently about their world. With Tinkamo’s various set of mindfully-designed sensors, controllers, and actuators, they can find and build creative solutions.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Smart Motor Block\n" +
                "DIY Gearbox to drive wheels\n" +
                "Claw to grab things\n" +
                "Launcher with 6 loads to shoot at a target\n" +
                "App and code enabled\n" +
                "\n" +
                "\n" +
                "Build 5 projects right out of the box, with instructions: \n" +
                "- Motocycle\n" +
                "- Race car\n" +
                "- SUV\n" +
                "- Walker Bot\n" +
                "- Automatic Tissue Dispenser\n" +
                "6 smart blocks\n" +
                "- Motor\n" +
                "- Servo\n" +
                "- Button\n" +
                "- Joystick\n" +
                "- Distance\n" +
                "- Core\n" +
                "300 plastic blocks.\n" +
                "With game map and coding courses.\n" +
                "Add-ons available.\n" +
                " Build 5 projects right out of the box, with instructions: \n" +
                "\n" +
                "\n" +
                "Build 10 projects right out of the box, with instructions:\n" +
                "- Motorcycle\n" +
                "- Race car\n" +
                "- SUV\n" +
                "- Walker Bot\n" +
                "- Automatic Tissue Dispenser\n" +
                "- Tank with sound-controlled launcher\n" +
                "- Path Finder\n" +
                "- Auto-pilot Car\n" +
                "- Music box with Color Sensor\n" +
                "- T-1 Robot with claw to grab things and Pixel Display to emotions\n" +
                "15 smart blocks\n" +
                "- Motor x 3\n" +
                "- Servo\n" +
                "- Button\n" +
                "- Slider\n" +
                "- Knob\n" +
                "- Joystick\n" +
                "- Distance Senso\n" +
                "- Color Sensor\n" +
                "- Path Finder\n" +
                "- Sound Sensor\n" +
                "- Pixel Display\n" +
                "- Core x 2\n" +
                "500 plastic blocks.\n" +
                "With game map and coding courses.\n" +
                "Add-ons available.\n" +
                "\n" +
                "Add-Ons\n" +
                "\n" +
                "Build a Ukulele and an Erhu using cardboard\n" +
                "With instruction to build, code and play\n" +
                "Works with Tinkamo Play & Tinker Kits \n" +
                "Play like a pro without real instrument experience\n" +
                "\n" +
                "Build a piano and a xylophone using cardboard\n" +
                "With instruction to build, code and play\n" +
                "Piano works with Tinkamo Play & Tinker Kits\n" +
                "Xylophone works with Tinkamo Tinker Kits\n" +
                "Play like a pro without real instrument experience\n" +
                "\n" +
                "To get add-ons, just add the price ($19 for each) to your original pledge, we will ask you for details when our project ends. \n" +
                "\n" +
                "20 Software blocks including AI speech and face cognition. 4 Apps for different level of users. Super easy drag'n'drop to code, enable every kid to code anytime, even without coding experience, sync codes wirelessly with Tinkamo blocks and see instant results, never let the fun wait. \n" +
                "\n" +
                "We've tested Tinkamo with a lot of kids, parents and teachers. We would like to take this opportunity to thank all our Tinker's Community members for their feedbacks, comments, sharing and inspirations. \n" +
                "Inside Tinkamo’s tiny blocks, are the latest Internet of Things technologies, ARM chips, Bluetooth Low Energy, rechargeable batteries and various sensors. We made them accessible through design so kids can use.\n" +
                "About Us\n" +
                "we are a team of designers, educators, mom, dads, makers and kids. In 2017.12, we joined the world's largest hardware accelerator HAX, and we've made steady progress since then, and as a small startup team, we don't always know everything, but we are lucky to have friends and advisors to help. We would like to thank everyone who ever helped us to get here.\n" +
                "\n" +
                "Please follow our Facebook and Instagram to find out more tinkers' creations. \n" +
                "\n" +
                "This project is promoted by Jellop, a direct\u00AD response online advertising agency specializing in Kickstarter campaigns on Facebook Ads and Google AdWords.\n" +
                "\n" +
                "Risks and challenges\n" +
                "\n" +
                "Every project will have challenges, and to make a product for kids is even more. The manufacturing process is often a long and complex one. Our prototypes are in an advanced stage and our playtime activities have been carefully crafted. We may seem plentifully prepared, but the road to product completion is not always as smooth as anticipated.\n" +
                "\n" +
                "Learn about accountability on Kickstarter\n" +
                "Questions about this project? Check out the FAQ");
        Item item4 = new Item(40,"mimicArm","Learn to Code Your Own A.I. Robot.Learn to Code Your Own A.I. Robot",2,4073.0,4073.0,1,new Date(2016-1900,12,21),"About\n" +
                "\n" +
                " What is mimicArm?\n" +
                "\n" +
                "mimicArm is a programmable collaborative A.I. robot. Using a building block approach to teaching, users will learn complex robotics programming in a gradual frustration-free way. As soon as it's constructed mimicArm works in manual mode and can execute pre-programmed example programs. Thanks to the intuitive nature of mimicArm, children as young as five can start using mimicArm right away.\n" +
                "\n" +
                "mimicArm Robots in Blue, Green, and Orange\n" +
                "mimicArm Robots in Blue, Green, and Orange\n" +
                "When the user is ready to start programming on their own mimicBlock offers a simple drag-and-drop programming environment. More complex programs can be written in C to perform more complex robotic tasks. Learn more about mimicArm here. There are plenty of educational robots out there, but mimicArm is the only true k-12+ robot available. No other educational robot combines the simplicity required for young students with the capability required for more experienced users.\n" +
                "\n" +
                "Other robots teach robotics of today.  mimicArm teaches robotics of tomorrow.\n" +
                "Other robots teach robotics of today. mimicArm teaches robotics of tomorrow.\n" +
                "What Does mimicArm do?\n" +
                "As a programmable A.I. collaborative robot (or cobot), mimicArm is a fun way to learn robotics and the foundations of programming robot/human interactions, robot decision making, and machine learning. mimicArm is fun and engaging from the very start. As soon as mimicArm is assembled the user can start using mimicArm in manual mode. Adding the scribbleBot attachment is even more fun.\n" +
                "\n" +
                "scribbleBot is always a fun!\n" +
                "scribbleBot is always a fun!\n" +
                "When the user is ready to start programming, pre-programmed examples ensure that users are able to start fast. The mimicBlock graphical programming language makes it easy for kids to load and alter programs from our website or write programs of their own. (You can download mimicBlock BETA now to see how it works). mimicBlock is similar to other programming curricula commonly used in classrooms and STEAM camps across the world, so it makes a great complement to other tools the user might be using. After learning the basics in mimicBlock more advanced programs can be written in C. These examples get pretty sophisticated, and you can learn more about them here.\n" +
                "\n" +
                "programming software builds the users abilities gradually\n" +
                "programming software builds the users abilities gradually\n" +
                "What Makes mimicArm Unique?\n" +
                "In manual mode mimicArm uses our patent pending Posi-Feel(tm) technology (learn more), which gives the user intuitive haptic feedback and allows sophisticated delicate manipulation not possible on other servo based robots. This not only provides intuitive feel, reducing operator frustration, but also allows the user to manipulate a variety of objects, from strong and heavy to very fragile. The inputBox (included in our Deluxe kit) comes pre-programmed to allow the user to use different inputs to interact with mimicArm right away. As the user learns to program mimicArm to perform ever more complex tasks they can develop a unique personality for their mimicArm based on the programming choices they make.\n" +
                "\n" +
                "There are other robots designed to teach programming, but only mimicArm is uniquely designed to teach interaction between robot and human. Through its unique design and combinations of sensors mimicArm is able to sense it's environment in such a way as to understand what a human is asking it to do. At the simplest, mimicArm can tell if it has grabbed a block it's been offered, while at it's most complex mimicArm is able to detect and reach for blocks, sort by size, communicate it's status, and receive instructions through a microphone or button. It's a great choice for everyone from robot novice to veteran programmer.\n" +
                "\n" +
                "Never programmed before? No problem! When you're ready, our simple yet powerful programming software gradually eases you into programming concepts and our downloadable experiments start simple to guide you every step of the way. The mimicArm circuit board takes care of the tough control system tasks so the user can program with simple intuitive commands like robotMove or robotGrab. The experiments incrementally increase in complexity until you're able to program using genuine C code just like the professionals, and your mimicArm becomes a genuine collaborative robot, capable of making decisions and learning. Want to pick up delicate objects without breaking them? mimicArm can do that. Want to record and playback a dance? mimicArm can do that. Need a shop assistant to hold your soldering iron? mimicArm can do that too. Add our available accessories and even more possibilities emerge.\n" +
                "\n" +
                "inputBox opens up a world of interactive possibilities inputBox opens up a world of interactive possibilities\n" +
                "inputBox opens up a world of interactive possibilities inputBox opens up a world of interactive possibilities\n" +
                "mimicArm is the only k-12 educational robot available. mimicArm leverages the popular Arduino microcontrollers and programming environment for nearly infinite expandability as the user’s abilities grow. Want to make mimicArm remote controlled? Use the remote included in our inputBox! Want to record and playback your motions? Use the inputBox microSD card! Want mimicArm to detect and move blocks? Use our IR Distance Sensor! Check out our Experiments Page for examples. Using these capabilities you can take mimicArm from a simple manually controlled robot all the way to an artificial intelligence machine capable of decision making and human interaction.\n" +
                "\n" +
                "That Sounds Great! Which Kit is Right for Me?\n" +
                "Everything you need to learn artifical inteligence programming\n" +
                "Everything you need to learn artifical inteligence programming\n" +
                "All of our mimicArm kits allow the user to get started in manual mode as soon as they’re assembled, come pre-programmed with simple A.I. examples, and are programmable. mimicArm kits are designed for easy assembly. Using the included wrench, screwdriver, and hex key you can fully assembl your mimicArm in a couple of hours. (Younger users will need an adult’s help). The kit includes all parts, fasteners, and tools needed. No soldering or other special skills are required. Buying for your local school? Let us know!  Our robots come pre-assembled if shipping to an educational institution. \n" +
                "\n" +
                "mimicArm starts simple, so anyone can use it right away\n" +
                "mimicArm starts simple, so anyone can use it right away\n" +
                "Reward Levels for Every User\n" +
                "Reward Levels for Every User\n" +
                "We offer reward levels for every user, from beginner to expert.\n" +
                "\n" +
                "mimicArm Kit:\n" +
                "\n" +
                "Recommended for beginners\n" +
                "\n" +
                "Our mimicArm Kit includes everything you need to use mimicArm in manual mode or start programming mimicArm. Our most affordable option, the mimicArm Kit is great for users looking to dip their toe into robotic programming and expand to other accessories later. The mimicArm kit includes all tools needed to assemble the kit so you can start using your robot quickly. This reward includes:\n" +
                "\n" +
                "mimicArm Robot\n" +
                "mimicArm Manual Controller\n" +
                "mimicDuino\n" +
                "mimicArm Super Fun Kit\n" +
                "\n" +
                "Recommended for beginner and intermediate users\n" +
                "\n" +
                "This reward centers around- you guessed it- fun! Including everything from the mimicArm Kit, the mimicArm Super Fun kit adds stacking blocks, the Great Big Button, and scribbleBot. Program fun activities like building a block castle or writing your name. The Great Big Button also adds basic human interactions to start learning A. I. collaborative programming. This reward includes:\n" +
                "\n" +
                "mimicArm Manual Controller\n" +
                "mimicDuino\n" +
                "Stacking Blocks\n" +
                "Great Big Button\n" +
                "scribbleBot\n" +
                "mimicArm Robot\n" +
                "mimicArm Deluxe Kit\n" +
                "\n" +
                "Recommended for intermediate and expert users\n" +
                "\n" +
                "Including everything from the Super Fun Kit, the mimicArm Deluxe kit adds the inputBox and IR Distance Sensor for maximum collaborative and A. I. possibilities.  Allow your robot to sense her environment and make decisions based on human input.  Program commands based on button presses.  React to the distance from a block.  Communicate your robot’s status using the RGB LED. React to sound using the inputBox microphone. The possibilities are endless! This kit includes:\n" +
                "\n" +
                "mimicArm Robot\n" +
                "mimicArm Manual Controller \n" +
                "mimicDuino \n" +
                "Stacking Blocks \n" +
                "Great Big Button \n" +
                "scribbleBot \n" +
                "inputBox\n" +
                "IR Distance Sensor\n" +
                "mimicArm Deluxe Classroom Set\n" +
                "\n" +
                "Five copies of our mimicArm Deluxe Kit, fully assembled if shipping to a US address.  Everything you need to get your STEAM classroom started learning robotics coding.  Buy a set for your favorite school!\n" +
                "\n" +
                "\n" +
                "mimicArm is Globally Loved!\n" +
                "\n" +
                "Check out our wonderful friends who have written about mimicArm\n" +
                "Check out our wonderful friends who have written about mimicArm\n" +
                "Media inquiries click here\n" +
                "\n" +
                "Risks and challenges\n" +
                "\n" +
                "mimicArm version 2 is an incremental improvement in capability and convenience over mimicArm version one, in use in schools across America now. As such risks are reasonably reduced. The improvements are primarily in the electronics, and there are some schedule risks if we make a mistake on the circuit boards as they take about 2 weeks to make. These risks are reduced by our prototypes and experience on the similar version 1 board. We’ll be completing the already started prototype testing process while the campaign is ongoing.");
        Item item5 = new Item(50,"Cast of Characters","An Immersive Queer Portrait Exhibition .Transform an independent queer bookstore with an exhibition of 90+ LGBTQ portraits.",1,10380.0,10380.0,1,new Date(2015-1900,4,2),"About\n" +
                "\n" +
                "About this project:\n" +
                "The Bureau of General Services—Queer Division and The Lesbian, Gay, Bisexual and Transgender Community Center will present Cast of Characters, a dramatic transformation of the Bureau by artist Liz Collins that features a salon-style exhibition of portraits by 95 queer artists. Cast of Characters will run from June 14 – September 16, 2018. The Donors reception will take place on Thursday, June 14, 2018, 6-9 PM, followed by the public opening reception on Friday, June 15, 2018, 6-9 PM.\n" +
                "\n" +
                "\n" +
                "Inspired by lavishly decorated and richly ornamented nineteenth-century libraries and salons, this immersive installation brings vibrant colors, dynamic patterns, and lush textures to the Bureau’s utilitarian aesthetic of plywood and cardboard. The exhibition will transform the Bureau into a warm, bright lounge, inspiring contemplation and conversation, beckoning visitors to linger, look, and read. With your help, we can make this project a reality!\n" +
                "\n" +
                "Exhibiting Artists\n" +
                "\n" +
                "Paula Allen, Lani Asuncion, Aziz + Cucher, Shimon Attie, Hannah Barrett, Nayland Blake, Marissa Bluestone, Chris Bogia, Justin Vivian Bond, Deborah Bright, Nancy Brooks Brody, Dietmar Busse, Nao Bustamente, Jai Carrillo, Cassils, Geoffrey Chadsey, Caroline Wells Chandler, Kyle Coniglio, Marco DaSilva, Niko Darling, Katrina del Mar, Leah DeVun, KD Diamond, Vincent Dilio, Angela Dufresne, Celeste Dupuy-Spencer, Nicole Eisenman, Scott Ewalt, Alesia Exum, Avram Finkelstein, C. Finley, Daphne Fitzpatrick, Chitra Ganesh, Andrea Geyer, Gary Graham, Stefanie Gudra, Martine Gutierrez, Barbara Hammer, Michelle Handleman, Jesse Harrod, Clarity Haynes, Karen Heagle, Mars Hobrecker, Elizabeth Insogna, Rindon Johnson, John Kelly, Amanda Kirkhuff, Kia LaBeija, Doron Langberg, Rebecca Levi, Myles Loftin, Shelley Marlow, Rodolfo Marron III, Aaron McIntosh, Eric McNatt, India Salvor Menuez, Lucas Michael, Troy Michie, Midori, Rodrigo Moreira, Carlos Motta, Zanele Muholi, Em North, Samantha Nye, Signe Olson, Alice O’Malley, Allison Michael Orenstein, Maia Cruz Palileo, Anna Parisi, Vick Quezada, LJ Roberts, Jason Rodgers, Gabriel Garcia Roman, JD Samson, Paul Mpagi Sepuya, Michael Sharkey, Lauryn Siegel & Virgil B/G Taylor, Charan Singh, SKOTE (Alex P White & Jill Pangallo), Buzz Slutzky, Tuesday Smillie, Sable Elyse Smith, Allison Smith, Pamela Sneed, Alexander Stadler, AK Summers, Aarav Sundaresh, Corinne Teed, Vincent Tiley, Mickalene Thomas, Boris Torres, Nicola Tyson, Conrad Ventur, Mickey Vered, Courtney Webster & Meg Turner, Ketch Wehr, Matthew Weinstein\n" +
                "\n" +
                "Why is this important? \n" +
                "\n" +
                "This project features a remarkable group of artists showing special works in a site-specific context. The show opens during PRIDE month and will be a grounding and celebratory site for folks to see a broad representation of LGBTQ creativity and life today in a context that queers a design strategy originated in traditional and formal domestic spaces. \n" +
                "\n" +
                "Loosely referencing the iconic exhibition and accompanying book The Family of Man, this enormous group of portraits by established to emerging queer artists will offer a broad and complex representation of contemporary queer life. The layers of patterns and colors of the carpet and wallpaper will function as a dynamic foundation to the portrayal of life through images and objects from a diverse cast of characters- which is how I imagine my community to come together in this show: the Family of Queers laid bare. \n" +
                "\n" +
                "Installation view of Persons of Interest exhibition at the Bureau, curated by Sam Gordon, featured a wide cross section of Visual AIDS artist members and friends. June 2 through September 18, 2016\n" +
                "Installation view of Persons of Interest exhibition at the Bureau, curated by Sam Gordon, featured a wide cross section of Visual AIDS artist members and friends. June 2 through September 18, 2016\n" +
                "The Bureau is an independent, all-volunteer queer cultural center, bookstore, and event space founded in 2012 and hosted by The LGBT Community Center in Manhattan since 2014. A beacon, a haven, and an essential space for the queer community, the Bureau serves as a bookstore, a performance space, an art gallery, and a place where queer people and friends go to find queer art, events, printed matter, information, and each other. This installation comes out of a deep love for the Bureau and a dedication to what it represents.\n" +
                "\n" +
                "What will your contribution support? \n" +
                "\n" +
                "The funds will go towards the production, transportation, installation and deinstallation of the exhibition: carpet, wallpaper, and 95 artworks. \n" +
                "\n" +
                "Layout of carpet in BGSQD space. This carpet is a reconfiguration of the custom carpet Collins created for her \"Energy Field\" installation at the Tang Museum (2015-2017) and is based on one of her drawings.\n" +
                "Layout of carpet in BGSQD space. This carpet is a reconfiguration of the custom carpet Collins created for her \"Energy Field\" installation at the Tang Museum (2015-2017) and is based on one of her drawings.\n" +
                "Design for Acid Rain Floral wallpaper, which Collins is producing for the project. The design is a response to climate change and integrates graphic elements from a table showing the increase in the earth's temperature over the past century.\n" +
                "Design for Acid Rain Floral wallpaper, which Collins is producing for the project. The design is a response to climate change and integrates graphic elements from a table showing the increase in the earth's temperature over the past century.\n" +
                "Why Kickstarter?\n" +
                "\n" +
                "There is no budget for this project - it has been entirely self-funded by the artist so far. Timing and administrative challenges have prevented it from following the grant application schedules, thus, crowdfunding is a great tool to both fund the last pieces of the project and extend its audience. So with your help, we can make this unprecedented project come to life!\n" +
                "\n" +
                "Given that this project is community-centered, we are asking the queer community and allies to help us make this ambitious exhibition a reality. Your donation will provide us with the necessary funds to offer this immersive exhibition of queer art to New Yorkers and the many visitors from around the world during Pride month and throughout the summer. Thank you for your support!\n" +
                "\n" +
                "This project will be made possible by individual donors to the Cast of Characters Kickstarter campaign and project sponsors.\n" +
                "\n" +
                "Image of Liz Collins' \"Cave of Secrets\" installation in the \"Trigger: Gender as a Tool and as a Weapon\" show at the New Museum in New York City (Sept 27, 2017-Jan 21, 2018)\n" +
                "Image of Liz Collins' \"Cave of Secrets\" installation in the \"Trigger: Gender as a Tool and as a Weapon\" show at the New Museum in New York City (Sept 27, 2017-Jan 21, 2018)\n" +
                "About the artist:\n" +
                "\n" +
                "Liz Collins in conversation with writer Jennifer Kabat at the closing event for \"Energy Field\", Collins' 2 year long installation at the Tang Museum at Skidmore College in Saratoga Springs, New York (October 2015-September 2017)\n" +
                "Liz Collins in conversation with writer Jennifer Kabat at the closing event for \"Energy Field\", Collins' 2 year long installation at the Tang Museum at Skidmore College in Saratoga Springs, New York (October 2015-September 2017)\n" +
                "Liz Collins surrounds the viewer in vibrating color and pattern fields to explore the boundaries between painting, fiber arts and installation. The cacophonic play of optics, texture, color and scale, recreates her wavering experience of the world as a place of stupendous wonder and cosmic energy. Collins has had solo exhibitions at the Tang Museum, Saratoga Springs, NY; Heller Gallery, NY; AMP Gallery, Provincetown, MA; and the Knoxville Museum of Art in Tennessee to name a few. Her work has been included in numerous exhibitions including at the ICA/Boston; Leslie Lohman Museum of Gay and Lesbian Art; the Museum of FIT; the New Museum; the Museum of Arts and Design and MoMA, and numerous group shows at galleries around the world. Collins’ awards include a USA Fellowship, a MacColl Johnson Fellowship, and residencies at AIR Alaska, Haystack, MacDowell, the Siena Art Institute, Stoneleaf, Yaddo, and the Museum of Arts and Design. She is a Queer Art Mentor, serves on the board of the Fire Island Art Residency, is a new member of the Exhibitions Committee at the Leslie Lohman Museum, and is one of the artists in the 2018-2020 Open Sessions program at the Drawing Center.\n" +
                "\n" +
                "About the Bureau:\n" +
                "\n" +
                "\n" +
                "The Bureau of General Services—Queer Division is an independent, all-volunteer queer cultural center, bookstore, and event space that opened in New York City in 2012 and has been hosted by The Lesbian, Gay, Bisexual & Transgender Community Center since 2014. We aim to foster a community invested in the values of mindfulness, intellectual curiosity, justice, compassion, and playfulness. The Bureau seeks to excite and educate a self-confident, sex-positive, and supportive queer community by offering books, publications, and art and by hosting a wide variety of cultural events, including readings, performances, film screenings, book discussion groups, and workshops. We provide local and visiting queers and friends with an open and inclusive space for dialogue and socializing.\n" +
                "\n" +
                "About The Center: \n" +
                "\n" +
                "\n" +
                "Established in 1983, New York City’s Lesbian, Gay, Bisexual & Transgender Community Center empowers people to lead healthy, successful lives. The Center celebrates diversity and advocates for justice and opportunity. Each year, The Center welcomes more than 300,000 visits to our building in the West Village neighborhood of Manhattan from people who engage in our life-changing and life-saving activities. To learn more about our work, please visit gaycenter.org.\n" +
                "\n" +
                "Some rewards:\n" +
                "- A VIP/ Donor Preview Reception for you and exhibiting artists on June 14, the evening before the exhibition opens to the public.\n" +
                "\n" +
                "Installation view of Coney Island Babies, curated by Chris Bogia and Montgomery Smith for Fire Island Artist Residency. The exhibition was on view at the Bureau from October 1 through November 27, 2016.\n" +
                "Installation view of Coney Island Babies, curated by Chris Bogia and Montgomery Smith for Fire Island Artist Residency. The exhibition was on view at the Bureau from October 1 through November 27, 2016.\n" +
                "  - A portrait session with one of a select group of the photographers in the exhibition.");
        Item item6 = new Item(60,"QooCam","World’s First interchangeable 4K 360° & 3D Camera,QooCam can shoot 4k 360° VR & 3D 180° video and photo. Featured Refocus, Shake-free, 120FPS, Time-lapse, Live Streaming, And App Editor ",2,400.00,100.00,1,new Date(2016-1900,12,21),"QooCam is the world’s first 4K camera that combines the most innovative features of both 360° & 3D stereo filming technology. Thanks to its unique 3 lenses, IMU stabilizer, and cutting-edge depthmap tech, QooCam features shake free, after-shooting refocus, 120 FPS, and time-lapse capabilities. \n" +
                "\n" +
                "Doesn’t matter if you are a professional or just getting started, you can freely direct and edit all your moments like a pro with QooCam’s Master Editor app.\n" +
                "\n" +
                "QooCam is designed for recording 4K videos and photos with a full 360° range. Thanks to its 4K with full sensor readout, you can record the memorable moments in great details and create high quality 360 videos on the go.\n" +
                "\n" +
                "PS: 360º 4K means the entire 360º video or photo is in 4K resolution. However, since you can only view the 360º video or photo in the different field of view and not the whole image, the content quality you’re watching on the traditional sized screen is going to be less than 4K.\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "Relive your moments as if you were there again with its amazing 3D 4K videos with a 180° wide angle. Capture and relive your moments like how you really experienced them the first time.\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "\n" +
                "\n" +
                "Using the latest and most revolutionary depth-based technology, QooCam allows you to refocus photos after shooting them. When shooting in the 3D 180º mode, QooCam can estimate the distance of the subjects in the frame and generate a depth map for special effects post-filming. \n" +
                "\n" +
                "Now, you can edit your photo and choose which the main subject of the content after shooting.\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "Tap on wherever you want to focus in. You will be able to create a bokeh effect, to enhance the subject in focus while giving the picture a fine background at the same time.\n" +
                "\n" +

                "Stop compromising when creating high-speed action shots, with the built-in IMU sensor plus the real-time stabilization software technology, and in-house algorithm, you can achieve shake-free shots and smooth videos even without a physical stabilizer.\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "\n" +

                "Qoocam’s stitching free feature automatically combines the images of both the lenses into one 360° spherical image. Thanks to its real-time optical flow stitching algorithm, you can directly get the perfect stitching on your 360° photo or video with just your smartphone.\n" +
                "\n" +

                "You can capture the 360° VR or 180° 3D video at 4K/60fps and 2K/120fps. You can easily create the highly used slow motion effect. There are endless possibilities for you to create with.\n" +
                "\n" +

                " project video thumbnail PLAY\n" +
                "With the time-lapse function, you can create time-lapse photography easily. You can set up the shooting frequency and QooCam will shoot the 360º or 3D photo automatically. Get the phenomenal time-lapse footage with ease.\n" +
                "\n" +

                "Enjoy a full 4k experience with QooCams’s three wide-angle lenses with a 216° field of view (FOV) and a f/2.2 aperture. Also with Sony’s CMOS sensor, the camera definition and battery life are improved, making it better than ever.  \n" +
                "\n" +

                "Built with a full aviation-grade anodized aluminum alloy body and CNC machined, Qoocam only weighs 170g; making it durable and good for cooling. It’s lightweight and durable body is perfect to carry around anywhere you go.\n" +
                "\n" +

                "Built to last longer, Qoocam’s battery supports 2600mAh, offering up to 180 minutes of continuous recording with a single charge.\n" +
                "\n" +

                "You can use the external Micro SD card to expand the camera's storage up to 256GB. You’ll have more freedom to shoot and record without the fear of storage shortage.\n" +
                "\n" +

                "With the Master Editor app, you can easily reframe and create 2D edits to your panoramic content with a simple tap and drag between the different points of views. Set the keyframes in your 360° videos and the app will automatically pan or zoom the 360° video to let you direct like a pro.\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "\n" +
                "With the smart track feature, you can keep track of your focus point’s every movement in a 4K 360° video. Just select the object or subject that you want to follow and the camera will do the rest to keep the object the center of the frame. \n" +
                "\n" +
                "PS: This function will finish its final testings after August.\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "\n" +
                "You can transform your photo or video into something out of this world. With one click, you can change the 360º images into cool tiny planet photos. You can even start a new trend craze on social media with these tiny planet selfies.\n" +
                "\n" +

                "With its Easy Share function, share amazing videos with your friends on your favorite social media platform.\n" +
                "Live stream 360° videos to show your friends your whole surrounding while you talk to them. QooCam supports USB and WiFi live streaming.\n" +
                "        PS: This function will finish its final testing after August.");
        Item item7 = new Item(70,"Emoji","the first hardcover book + app of the original emoji, In 1999 Japan debuted the original 176 emoji. Now, we're releasing the first hardcover book and smartphone keyboard of these drawings.",1,75332.0,75332.0,1,new Date(2015-1900,4,2),"In 2016, the Museum of Modern Art in New York made an unusual acquisition for their permanent collection: the world’s original emoji, designed by Shigetaka Kurita at NTT DOCOMO and released in Japan in 1999.\n" +
                "\n" +
                "Now, almost two decades later, we are releasing the first hardcover book and smartphone keyboard of these drawings—the direct ancestors of the emoji we all use today.\n" +
                "The original 176 emoji, NTT DOCOMO, 1999\n" +
                "The original 176 emoji, NTT DOCOMO, 1999\n" +
                "Shigetaka Kurita designed the original emoji for the Japanese telecommunications giant NTT DOCOMO when he was just 25 years old. The name was created from the Japanese “e,” which means picture, and “moji,” which means character. At the time, Kurita and DOCOMO had no idea that their work would leave Japan, evolve, and eventually be used by billions of people on a daily basis, and revolutionize the way we communicate today.\n" +
                "\n" +
                "Shigetaka Kurita, designer of the original emoji set\n" +
                "Shigetaka Kurita, designer of the original emoji set\n" +
                " “Various things influenced emoji. One was the pictogram. Pictograms are used as signs in many places in Japan like stations and public places. The second was the Japanese art of Manga, which uses graphics to express emotion. Lastly, it was Japanese magazines. All of these things that organize and communicate information came together to influence the creation of emoji.” \n" +
                "\n" +
                "—Shigetaka Kurita, designer of emoji\n" +
                "\n" +
                "\n" +
                "\n" +
                "The book\n" +
                "\n" +
                "The book will be wrapped in a green vinyl jacket, a typical Japanese book making technique. The front and back covers are screenprinted with all 176 emoji.\n" +
                "The book will be wrapped in a green vinyl jacket, a typical Japanese book making technique. The front and back covers are screenprinted with all 176 emoji.\n" +
                "\n" +
                "The book, simply titled Emoji, studies and honors Kurita and DOCOMO’s creation, as well as the explosion across the globe of their unintentional works of art.\n" +
                "\n" +
                "The cover is wrapped in a green PVC jacket with screenprinted title\n" +
                "The cover is wrapped in a green PVC jacket with screenprinted title\n" +
                "Emoji will present images of sketches and digital artwork with technical data from DOCOMO for each character. It will also include an introduction by Kurita and an essay by The Museum of Modern Art's (MoMA) Paola Antonelli and Paul Galloway.\n" +
                "\n" +
                "Four versions of each emoji will be included in the book: color 1:1 scale, enlarged in color, black and white with underlying grid, and black and white 1:1.");
        Item item8 = new Item(80,"Microscope Kit","Explore the invisible microscopic world around you with an affordable microscope kit you construct yourself.",2,18271.0,18271.0,1,new Date(2016-1900,12,21),"About\n" +
                "\n" +
                "Microscopic worlds\n" +
                "\n" +
                "From dust motes, bacteria, chlorophyll and amoebas, a strange and fantastic world surrounds us. Working with people around the world, Public Lab has developed an affordable way to peek into this hidden world.\n" +
                "\n" +
                "\n" +
                "Using simple materials, we’ve developed a kit you can build yourself - the result of many teams’ work coming together! Introducing the Community Microscope:\n" +
                "\n" +
                "\n" +
                "It takes only fifteen minutes to build, and plugs into a smartphone or laptop. It’s a simple but elegant design -- you focus it by tightening the bolts, and the basic version is made from a webcam with its lens flipped upside down.\n" +
                "\n" +
                "Public Lab is an open community of activists, tinkerers, organizers, makers, educators and scientists around the world, who have worked together to design this kit. We’ve worked with a growing coalition to take a Do-It-Yourself approach to environmental justice issues.\n" +
                "\n" +
                "We welcome you to join in making these techniques more accessible!\n" +
                "\n" +
                "\n" +
                "The Community Microscope Kit\n" +
                "\n" +
                "We’re offering a range of options with mix-and-match components -- start with the intro kit and we'll be offering upgrade kits after the campaign.\n" +
                " \n" +
                "The Intro Kit\n" +
                "\n" +
                "This kit is very simple: a webcam, a platform of corrugated plastic, a set of nuts, bolts & rubber bands, and some double-sided adhesive strips! With it, you can easily see objects as small as 5 microns (a micron is 1/1000 of 1 millimeter), such as plant cells and the single-celled organisms that swim around in pond water and puddles. This kit is great for people who want to get started quickly and experiment with the way their microscope is put together.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Lens Upgrades\n" +
                "\n" +
                "We also have more advanced models for people who want to look at different things, take higher-quality photographs, and use stronger magnification lenses.\n" +
                "\n" +
                "Everything is designed to fit together, so if you start with the basic kit, there’s a clear upgrade path to better components later. But using a microscopic ruler, we found that even with the webcam version, you can see things as small as 5 microns wide -- 8x smaller than a human hair!\n" +
                "\n" +
                "\n" +
                "Microscope Plus & Super Microscope Kits\n" +
                "\n" +
                "The next step up (the Plus Kit) includes an adapter to a 20x microscope objective lens -- enabling you to see much smaller objects with better optics. Because of the modular construction of our kit, you can simply swap in the lens and raise the platform to accommodate it. Our Super Microscope Kit will include a 40x lens.\n" +
                "\n" +
                "\n" +
                "See how the parts fit together in a modular system; the larger lenses replace the flipped webcam lens shown here, and all cameras and lenses are interchangeable:\n" +
                "\n" +
                "\n" +
                "Camera Upgrades\n" +
                "\n" +
                "For use with higher quality lenses, we also offer kits with upgraded cameras -- the Raspberry Pi camera.See how the parts fit together in a modular system; the larger lenses replace the flipped webcam lens shown here, and all cameras and lenses are interchangeable\n" +
                "\n" +
                "\n" +
                "Pi Camera Microscope Kit\n" +
                "\n" +
                "The Pi Camera kit includes a much higher resolution Raspberry Pi camera (v1.3) -- at 5 megapixels. In this prototype we were testing rubber bands, but the final will feature springs along with its laser-cut acrylic platforms:\n" +
                "\n" +
                "\n" +
                "Additional higher-end versions like our Super and Deluxe Pi Camera Microscope Kits include up to 100x microscope lenses! And our Classroom Kit includes materials for a whole class of students to make five microscopes. \n" +
                "\n" +
                "2 micron sized particles through a Raspberry Pi microscope\n" +
                "2 micron sized particles through a Raspberry Pi microscope\n" +
                "How did we get here?\n" +
                "\n" +
                "Not only does this kit build on the work of open source science groups like Parts & Crafts, Hackteria, Lifepatch and the Open Flexure Microscope project, but because of Public Lab's mission to address environmental problems that affect people, we also worked with communities who are facing air pollution which they hope to photograph with these kits.\n" +
                "\n" +
                "\n" +
                "Public Lab has been working with people across Wisconsin who’ve seen pollution from a boom in frac sand mining -- mining vast amounts of sand to use in oil and gas frac operations in other states. The especially worrisome part is a form of air pollution called respirable silica -- a fine, sharp-edged crystalline dust which can cause respiratory problems -- blowing over and into peoples homes and yards.\n" +
                "\n" +
                "\n" +
                "Although many efforts to document pollution use expensive air samplers, lab tests and equipment, people living around the mines can see dust piling up on their windowsills and in their homes.\n" +
                "\n" +
                "Some community members sought a way to actually see these particles as small as 2.5 microns in size - an idea which led to the Community Microscope project. These photos could be used in advocacy and to raise awareness, but may also be helpful to see what particles are made of, just by examining them visually.\n" +
                "\n" +
                "High quality image taken using 100x lens and Raspberry Pi camera\n" +
                "High quality image taken using 100x lens and Raspberry Pi camera\n" +
                "Why we need you\n" +
                "\n" +
                "Now we need you to take the next step. Community efforts like these only work if we build a broad, inclusive community of practice.\n" +
                "\n" +
                "That means we need activists, educators, hobbyists, and professional scientists to join in, and work together. We need illustrators and writers to present these ideas clearly. Engineers and tinkerers to refine the open source kits! We need all kinds of skills and backgrounds, so this means you!\n" +
                "\n" +
                "How can you get involved? We're building a list of challenges and goals, and need your help to:\n" +
                "\n" +
                "try it out -- look at many different things! \n" +
                "troubleshoot and refine its assembly improve the lighting system \n" +
                "identify and address rough spots in the design \n" +
                "produce documentation and even curriculum \n" +
                "teach workshops and host community events\n" +
                "and much more to come!\n" +
                "Sign up for a kit today and help bring this project to life.\n" +
                "\n" +
                "A Do-It-Yourself approach\n" +
                "\n" +
                "Public Lab, the open source community which launched the DIY spectrometer, the Balloon Mapping Kit, and the Infragram camera, has been working with community groups around the world who need affordable microscopes to photograph air pollutants, measure ocean microplastics, and identify other kinds of microscopic environmental problems.\n" +
                "\n" +
                "Luckily, many open source groups around the world -- like Hackteria and the OpenFlexure Microscope team, as well as folks in the Public Lab network -- have been working for years to make scientific research accessible to anyone who wants to participate.\n" +
                "\n" +
                "Building an alliance\n" +
                "\n" +
                "How did these people all work together to get this far? Public Lab follows a coalition building model, where we connect people from around the world to cooperate on shared problems, like measuring air and water pollution. When communities facing pollution can team up with a larger community of makers, educators, and organizers, they can call in help, lead problem definition, and ensure that work is focused on a real-world problem.\n" +
                "\n" +
                "8 years of Public Lab\n" +
                "\n" +
                "We've worked with communities around the world for eight years -- since the BP oil disaster, and we've run several Kickstarters to distribute affordable science tools to people who need them. \n" +
                "Risks and challenges\n" +
                "\n" +
                "NOT “JUST A STORE”\n" +
                "\n" +
                "Distributing kits as we do, it’s always a risk that people will think of us as an online business, and not a growing community (and a non-profit) where their involvement is more important than the money they spend. We’re doing our best to communicate what we’re about through the story above, but we’re also dedicated to shaping the objects themselves, their boxes and packaging, to communicate this ethos. That said, we've run five successful Kickstarters in this way, and have been distributing tens of thousands of kits around the world for eight years -- so it's not new to us!\n" +
                "\n" +
                "TACKLING CHALLENGES TOGETHER\n" +
                "\n" +
                "Part of the challenge of Public Lab work in general is to encourage people to share and build things together -- not just things they’ve done, but questions they want to ask, concerns they have, and requests for help. Sometimes it can feel like these are impositions on everyone else, but at Public Lab we celebrate them as the very foundation of the collaborative process. Sharing half-completed projects, doubts, and frustrations can help invite others into your work and strengthen it.\n" +
                "\n" +
                "Of course, it can also be a challenge to encourage people to report back when they do projects. These projects are about more than “tools” -- they’re about the stories that come from people adapting, reshaping, and applying them to a thousand different problems or scenarios. We’ll be highlighting many of the stories of people’s amazing work with balloon mapping kits\n" +
                "\n" +
                "Finally, these essentials -- engagement in collective brainstorming, troubleshooting, and sharing -- are even more important with the Prototyping Kits we're introducing. These kits have a range of issues and unknowns to tackle, and we’re counting on you all to get involved and put them through their paces.");
        Item item9 = new Item(90,"KLOS Guitars","Carbon fiber, impervious to temperature and humidity, collapsible at the neck, full size and full sound - it will last a lifetime",1,1140.0,1140.0,1,new Date(2015-1900,4,2),"KLOS Guitars has taken the experience from shipping nearly 2000 travel guitars to over 70 countries and all 50 states and selling hundreds of carbon fiber ukuleles to now finally present the full size guitar. The KLOS full size guitar is completely re-designed with modern materials, new technologies, a re-engineered structural design, and up to date manufacturing methods. The result is a strong, reliable, easy to play, and beautiful looking and sounding full size guitar. \n" +
                "\n" +
                "\n" +
                "KLOS Guitars produces instruments that challenge each of our customers to keep their music close to them no matter what they do or where they go, hence the motivation for our #keepitKLOS tagline. Our guitar customers have hiked the Pacific Crest Trail, cycled from Montreal to San Diego with a guitar, summited and played Stairway to Heaven at the peak of Denali, traveled to the South Pole, and more. We're excited to see what the next wave of KLOS customers will do with these ukuleles!\n" +
                "\n" +
                "Interested in our TRAVEL GUITAR or UKULELE? \n" +
                "\n" +
                "Order now to claim a deal happening only during this crowdfunding campaign\n" +
                "\n" +
                "It's better that you find out now about the reality of wooden guitars. Although wooden guitars can be amazing instruments, the truth is they are not very durable. \n" +
                "\n" +
                "With time, the string tension on the bridge warps the soundboard, which negatively impacts sound and playability. With temperature and humidity changes, the soundboard, body, and neck will all change, making a perfect setup in one environment a bad one somewhere else.\n" +
                "\n" +
                "We solve all of these problems by making the body and sound board out of carbon fiber, and adding an optional upgrade to have carbon fiber stiffening rods in the neck. Check out some of the tests we've done with our other instruments.");
        Item item10 = new Item(100,"Served: A Missionary Comics Anthology","A book of short comics by returned Mormon missionaries about their missions in different parts of the world.",2,400.00,100.00,1,new Date(2016-1900,12,21),"Thank you, everyone, for helping us reach this milestone! We've only got a dozen days to go and we want to catch everyone who's interested. Signal-boosting always welcome. Or not. No pressure. Just take this book and we'll talk next week?\n" +
                "\n" +
                "Lately I've been getting emails via Kickstarter from fellow SERVED contributor Cam Kendall who has a book getting closer daily to arriving in my mailbox. It sounds cool.\n" +
                "\n" +
                "The funny thing is that until a couple weeks ago I had completely forgotten this book existed! So many people on our list have so many projects going that it's hard to keep track! I'm grateful all these talents signed on and are cooperating to bring this inside-look at missionarying to the world. Pretty cool.\n" +
                "\n" +
                "Here's a bit from Cam's story to start your weekend with:"+
                "UPDATE: $19,292. So close to twenty. So, so close.\n" +
                "\n" +
                "The magazine LDS Living posted online about our project, and we gave them some exclusive clips from ten of the works included in SERVED.\n" +
                "\n" +
                "Nine of the ten artists featured in their article have not already been featured in these updates, so you're about to, what, quadruple the number of artists you've been introduced to? So click on over! Meet Anthony and Brittany and Scott and Josh and Brad and Darren and Bethany and Normandie and Lance!\n" +
                "\n" +
                "One word about Brad, because I think you may have a question when you read what is said about him: Yes.\n" +
                "\n" +
                "Yes, this is the same Brad Teare who did Cypher back in the '90s. And he also did work for The Friend. And yes, all his work is this awesome.");

        carSet.add(item1);
        carSet.add(item2);
        carSet.add(item3);
        carSet.add(item4);
        carSet.add(item5);
        carSet.add(item6);
        carSet.add(item7);
        carSet.add(item8);
        carSet.add(item9);
        carSet.add(item10);

        int i=1;
        for (Item item:carSet){
            Item_Owner item_owner=new Item_Owner(i++,financier1.getUser_ID());
            session.save(item_owner);
        }

        session.save(financier1);
        session.save(item1);
        session.save(item2);
        session.save(item3);
        session.save(item4);
        session.save(item5);
        session.save(item6);
        session.save(item7);
        session.save(item8);
        session.save(item9);
        session.save(item10);


        // 3.1  2号融资人添加了10个项目
        Set<Item> carSet2 = new HashSet<>();
        Item item11 = new Item(110,"LÖK ZINE #10 DIMENSIONS \\ DIMENSIONI","LÖK ZINE is an independent comics and illustration magazine. The authors come from all around the world.",1,1980.0,1980.0,1,new Date(2017-1900,2,1),"ENG  \n" +
                "\n" +
                "LÖK ZINE# 10 DIMENSIONS / DIMENSIONI is going to be a bilingual (english and italian) comics and illustration anthology, with more than 120 pages in colors, paperback, size A4 8,3 x 11,7 \".\n" +
                "\n" +
                "LÖK ZINE is an independent comics and illustration magazine.The guiding theme changes in each issue and artists from all over the world give life to them. \n" +
                "Here's its tenth issue! In order to celebrate this landmark we decided to make some changes: the contributions are in full color and we doubled the page count. Quite the dimensions change! As suggested by the theme. \n" +
                "Dimension represents the degrees of freedom with which a point can move in space, these degrees are described by measures that define a shape and a size. We're talking about big, small, narrow, large, but also about dimensions in a wider sense, the space, the relationship we have with it and parallel universes, everything told through our authors' hands.\n" +
                "\n" +
                "We hope the simple two dimensions of paper can transport you to a world where you'll be able to imagine, feel and live an unforgettable experience.\n" +
                "\n" +
                "Comics by Elisa Caroli\n" +
                "Comics by Elisa Caroli\n" +
                "ITA \n" +
                "\n" +
                "LÖK ZINE# 10 DIMENSIONI / DIMENSIONI Sarà un' antologia bilingue (Inglese e Italiano) COMPOSTA da fumetti e illustrazioni , di Oltre 120 pagine Completamente A Colori , con rilegatura brossurata , formato A4 21,0 × 29,7cm.\n" +
                "\n" +
                "LÖK ZINE è una rivista indipendente di fumetto e illustrazione. Ha temi diversi in ogni uscita e io vivo da tutto il mondo . \n" +
                "Ecco il suo decimo capitolo! \n" +
                "Per celebrare questo traguardo abbiamo deciso di fare qualcosa di nuovo: i contenuti sono completamente a colori e il numero delle pagine è più che raddoppiato. Un bel cambio di Dimensioni! Vieni suggerito il tema di questo numero. \n" +
                "La dimensione è un modo di muoversi all'interno dello spazio. Sienne quindi di grande, piccolo, stretto, largo, ma anche di dimensioni in senso più ampio, lo spazio, il rapporto con ciò che circonda ei mondi paralleli, il tutto raccontato dai segni dei nostri autori .\n" +
                "\n" +
                "Speriamo che le sole due dimensioni del foglio vi trasportino in un mondo dove poter immaginare, sentire e vivere un'esperienza indimenticabile.");
        Item item12 = new Item(120,"20th ANNIVERSARY CELEBRATION","We curate and produce an annual feature length film, comprised of the best and newest animated shorts. Celebrating our 20th anniversary",2,12624.00,12624.00,1,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "The Animation Show of Shows (ASOS) is an annual event in which the world’s best animated short films are curated and presented in one feature-length film, to audiences worldwide. The ASOS brings animated short films to homes via streaming and DVD, and to the BIG screen in theaters around the world. It has been its mission and privilege to shine a spotlight on the brilliance of independent animators, support and preserve an important art form, while providing a moving cinematic experience for audiences.\n" +
                "\n" +
                "\n" +
                "This is our 20th anniversary! \n" +
                "\n" +
                "We are amazed, excited, grateful, and filled with pride. We feel our 20th anniversary is a historic milestone, and accordingly, we are celebrating.\n" +
                "\n" +
                "We will be celebrating this special anniversary ... by curating TWO shows, The 20th Annual Animation Show of Shows, and a first-ever \"BEST OF\" Animation Show of Shows. We further the celebration by featuring a very special array of new and creative Rewards..\n" +
                "\n" +
                "Thanks so much for visiting, we hope you join our celebration, and thanks in advance for your support!\n" +
                "\n" +
                "===\n" +
                "\n" +
                "The Animation Show of Shows is a 501(c)(3) not for profit organization, and by virtue of this status, pledges made to this campaign are tax-deductible, to the amount and extent allowable by law. See the FAQ's below.\n" +
                "\n" +
                "===\n" +
                "\n" +
                "ABOUT THE ANIMATION SHOW OF SHOWS\n" +
                "\n" +
                "Continuously since 1990, Ron Diamond was producing animation, marveling at the talent he was discovering - not just locally, but across the globe. Ron perceived that independent animators were producing short films that were poignant and brilliant, but despite their brilliance, these films often went unnoticed in the U.S. Ron also felt that animated shorts, more than any other genre of film, took on the personality of their creators.  Because of this, they tended to evoke greater emotion and really connect with their audience.  He wanted to share this wealth of great animation with the wider animation industry. In 1999, he produced the first-ever Animation Show of Shows. \n" +
                "\n" +
                "From the very first Animation Show of Shows: “When the Day Breaks”, 1999 Canada, directed by Wendy Tilby and Amanda Forbis\n" +
                "From the very first Animation Show of Shows: “When the Day Breaks”, 1999 Canada, directed by Wendy Tilby and Amanda Forbis\n" +
                "During the early days of The Animation Show of Shows, Ron built on his relationships with animation festivals, studios, and leading college programs, which enabled him to discover still greater talent for inclusion in future shows. Each year, after curating the newest edition of the ASOS, he shared it with top animation studios, game and technology companies, and schools, helping to foster greater awareness of budding and amazingly talented animators. \n" +
                "\n" +
                "Animators and their films can attain great acclaim. Two examples are “World of Tomorrow” 2015 by Don Hertzfeldt (USA) and “Everything” by David OReilly 2017 (USA).\n" +
                "Animators and their films can attain great acclaim. Two examples are “World of Tomorrow” 2015 by Don Hertzfeldt (USA) and “Everything” by David OReilly 2017 (USA).\n" +
                "The Animation Show of Shows continued to grow in size and status, and began to garner industry acclaim.  \n" +
                "\n" +
                "\n" +
                "In 2015, Ron felt it was finally time to take the show to the public. The Animation Show of Shows became a 501(c)(3) not for profit and ran its first campaign on Kickstarter to help fund an expansion into theaters and other public venues, and to allow the newly-formed not for profit to pay advance monies to the filmmakers for worldwide rights. \n" +
                "\n" +
                "\n" +
                "Thanks to generous support from industry professionals, students and fans of animation, the 17th Annual Animation Show of Shows premiered at venues in 47 cities, 4 countries, for a total of 435 showings. Since then, its reach has grown and fans of animation continue to support, through successive Kickstarter campaigns, the expansion of the Show into more venues. Every year since the 17th edition, those numbers have nearly doubled. The 19th Annual Animation Show of Shows is playing in theaters in North America with plans for additional international and educational expansion ...\n" +
                "\n" +
                "\n" +
                "TWENTY YEARS - WOW! HOW TO CELEBRATE?\n" +
                "\n" +
                "We are marking this celebratory occasion by producing, for the first time, TWO Animation Show of Shows - the 20th Annual Animation Show of Shows, and a \"Best Of\" Animation Show of Shows featuring the elite of  the elite from past shows. \n" +
                "\n" +
                "We are also offering new and different Rewards, some that we've never offered before. \n" +
                "\n" +
                "\"THE BEST OF\" COMPILATION\n" +
                "\n" +
                "Since inception, 38 of the films featured in the Animation Show of Shows went on to receive Oscar nominations. Even more received recognition at the most prestigious animation festivals around the world. So curating our Best Of Animation Show of Shows \"ain't gonna be easy.\" But we're up to the task. \n" +
                "\n" +
                "Oscar-nominated films from previous Animation Show of Shows -  L to R: \"We Can't Live without Cosmos\" by Konstantin Bronzit 2015 (Russia); \"Pearl\" by Patrick Osborne 2016 (USA); \"Dear Basketball\" by Glen Keane 2017 (USA) with Kobe Bryant\n" +
                "Oscar-nominated films from previous Animation Show of Shows - L to R: \"We Can't Live without Cosmos\" by Konstantin Bronzit 2015 (Russia); \"Pearl\" by Patrick Osborne 2016 (USA); \"Dear Basketball\" by Glen Keane 2017 (USA) with Kobe Bryant\n" +
                "Our  Best Of show will also be seen in theaters.  \n" +
                "\n" +
                "ANIMATION TALENT IS TRULY GLOBAL \n" +
                "\n" +
                "Some of the finest animated shorts that have been selected for inclusion in the Animation Show of Shows hail from talented animators in places you wouldn't expect. Says Ron: \"The true global nature of the animated shorts and their makers are among the most fulfilling aspects of what we do.\"\n" +
                "\n" +
                "The principal language of the Animation Show of Shows is English, but the 17th edition has been subtitled into French, Italian, German, Spanish, Polish, Japanese, Mandarin, Korean, Vietnamese, and Russian.\n" +
                "\n" +
                "Here are a few of the wonderful films featured in recent ASOS shows, from talented animators across the globe: \n" +
                "\n" +
                "L to R: \"Blue\" by Daniela Sherer 2016 (Israel) ; The Burden by Niki Linderoth von Bahr 2017 (Sweden) ; Afternoon Class by Seoro Oh 2015 (Korea)\n" +
                "L to R: \"Blue\" by Daniela Sherer 2016 (Israel) ; The Burden by Niki Linderoth von Bahr 2017 (Sweden) ; Afternoon Class by Seoro Oh 2015 (Korea)\n" +
                "L to R: \"Stripy\" by Babak Nekooei & Behnoud Nekooei 2015 (Iran); \"About a Mother\" by Dina Velikovskaya 2015 (Russia); \"Waiting for the New Year\" by Vladimir Leschiov 2016 (Latvia)\n" +
                "L to R: \"Stripy\" by Babak Nekooei & Behnoud Nekooei 2015 (Iran); \"About a Mother\" by Dina Velikovskaya 2015 (Russia); \"Waiting for the New Year\" by Vladimir Leschiov 2016 (Latvia)\n" +
                "ALWAYS BREAKING NEW GROUND\n" +
                "\n" +
                "The Animation Show of Shows not only looks across the globe, but also \"outside the box\" for top-quality animated shorts that are distinct, innovative, unique, experimental, and diverse - whether in content, style, or in other ways. \n" +
                "\n" +
                "Among the many great films by women directors - L to R: “Messages Dans L’Air” by Isabel Favez 2015 (Switzerland/France); “Crin-Crin” by Iris Alexandre 2015 (Belgium); “Les Abeilles Domestiques” by Alexanne Desrosiers 2017 (Canada)\n" +
                "Among the many great films by women directors - L to R: “Messages Dans L’Air” by Isabel Favez 2015 (Switzerland/France); “Crin-Crin” by Iris Alexandre 2015 (Belgium); “Les Abeilles Domestiques” by Alexanne Desrosiers 2017 (Canada)\n" +
                "The Animation Show of Shows has been proud to highlight films that pioneered or mastered innovative animation techniques.\n" +
                "\n" +
                "L: \"Stems” by Ainslie Henderson 2015 (Scotland) Stop Motion; R: “The Battle of San Romano” by Georges Schwizgebel 2017 (Switzerland) Paint.\n" +
                "L: \"Stems” by Ainslie Henderson 2015 (Scotland) Stop Motion; R: “The Battle of San Romano” by Georges Schwizgebel 2017 (Switzerland) Paint.\n" +
                "L: “Boygen” by Kristian Pedersen 2016 (Norway) featured experimental computer animation; R: “Here and the Great Elsewhere” by Michèle Lemieux 2012 (Canada) featured pin screen animation.\n" +
                "L: “Boygen” by Kristian Pedersen 2016 (Norway) featured experimental computer animation; R: “Here and the Great Elsewhere” by Michèle Lemieux 2012 (Canada) featured pin screen animation.\n" +
                "IN SEARCH OF BUDDING TALENT\n" +
                "\n" +
                "The Animation Show of Shows maintains relationships with colleges and universities, especially focused on students pursuing careers in animation. We feature truly exceptional student films in our curatorial process. We always offer a special spotlight on accomplished student films as rewards at inclusive pricing. \n" +
                "\n" +
                "Student films: L to R: “Gokurosama” - 6 students from MOPA 2016 (France); “Next Door” - Pete Docter 1990 (USA); “Shift” - Cecilia Puglesi & Yijun Liu 2015 (USA)\n" +
                "Student films: L to R: “Gokurosama” - 6 students from MOPA 2016 (France); “Next Door” - Pete Docter 1990 (USA); “Shift” - Cecilia Puglesi & Yijun Liu 2015 (USA)\n" +
                "CREATOR COMMENTARY ON THE MISSION: EXPANDING AWARENESS AND PRESERVING AN ART FORM  \n" +
                "\n" +
                "\"Sitting in a dark theater, discovering a truly great and powerful film for the first time is an incredible experience. I like to think that we bring that same incredible feeling to our public and academic audiences. As I reflect back on the past editions of Animation Show of Shows, I recall the same excitement and enthusiasm for all those audiences. Our preservation efforts in restoring animated shorts introduces our audiences to \"new older\" films, which we feature in the same way they were intended to be seen when they were new.\"\n" +
                "\n" +
                "Two independent animated shorts that have become all-time fan favorites, with cult-like adoration: “Cat Came Back” by Cordel Barker 1988 (Canada);  “Hangman” by Paul Julian & Les Goldman 1964 (USA)\n" +
                "Two independent animated shorts that have become all-time fan favorites, with cult-like adoration: “Cat Came Back” by Cordel Barker 1988 (Canada); “Hangman” by Paul Julian & Les Goldman 1964 (USA)\n" +
                "\n" +
                "\"I'm truly honored to be celebrating 20 years of the Animation Show of Shows. It's been fulfilling to be entrusted by the filmmakers with their films and by the audiences with their time. It's also very difficult, and what I mean is – these works are often by young animators, always brimming with passion, overflowing with talent, but lacking in money and anticipating being discovered. As the number of films produced each year has grown, the process of selecting which films to invite in the show has become tougher. I often wish I could include more films, and add to my support and appreciation for what these young artists can create. The support we have been able to show for the independent animator is a direct result of the support we've received on Kickstarter and from the community of fans of exemplary animated shorts. We will continue to do what we do, and hope you will continue to support our efforts, our shows, and the animated short film. Thank you for the opportunity to have this celebration.\" - Ron");
        Item item13 = new Item(130,"EARTH: An immersive AR/AI experience","A 3D-printed, hand-painted globe taking you through time to explore our planet’s geological changes, wildlife, weather patterns & more!",1,300.00,200.00,1,new Date(2017-1900,2,1)," EARTH is the first-ever augmented reality-enabled globe that lets you see our planet’s changes across history. Just open the app and point your phone’s camera at the model for a deeply immersive learning experience.\n" +
                "\n" +
                "The app displays information on several in-depth categories: \n" +
                "\n" +
                "\n" +
                "Ever wondered how many gallons of water are in the ocean? \n" +
                "\n" +
                "With EARTH you can track geology, to study the formation and evolution of our physical planet.\n" +
                "\n" +
                "Curious about what animals inhabited your country 1,000 years ago? \n" +
                "\n" +
                "With EARTH you can track the migration and habitats of animals past and present.\n" +
                "\n" +
                "And much more!\n" +
                "\n" +
                "EARTH's technology takes you through time to explore our planet’s rich geographic history, along with the current state of our world due to climate change, natural disasters, and more.\n" +
                "EARTH's technology takes you through time to explore our planet’s rich geographic history, along with the current state of our world due to climate change, natural disasters, and more.\n" +
                "The deeply-layered, interactive experience covers basic geographic information such as landmarks, latitude and longitude, time zones, and regions.\n" +
                "The deeply-layered, interactive experience covers basic geographic information such as landmarks, latitude and longitude, time zones, and regions.\n" +
                "The app also displays complex visualization across various topics such as heatmaps, cloud atlases, point maps, texture maps, and more.\n" +
                "The app also displays complex visualization across various topics such as heatmaps, cloud atlases, point maps, texture maps, and more.\n" +
                "Control EARTH with your voice\n" +
                "While you explore the globe with your hands, use our smart voice technology—named Gaea, powered by Microsoft LUIS—to direct the app and discover a wealth of information about earth.\n" +
                "\n" +
                "Here are a couple questions you can ask Gaea across the various categories. Just say \"Hey Gaea!\" and ask away...\n" +
                "\n" +
                "\n" +
                "\n" +
                "Gaea is here to help with your journey across time and space.\n" +
                "Gaea is here to help with your journey across time and space.\n" +
                "Gaea displays the information you want, right before your eyes.\n" +
                "Gaea displays the information you want, right before your eyes.\n" +
                " Or, get Gaea to navigate you around the app!\n" +
                "\n" +
                "Hey Gaea, show me the areas of temperate grassland around the globe. \n" +
                "Hey Gaea, let's leave the animal section and see the Earth's structure.\n" +
                "Using art, technology, and science to educate\n" +
                "\n" +
                "Beyond the physical globe of EARTH, the AstroReality App contains a wealth of scientific knowledge selected to show our planet as a dynamic and interconnected system. This knowledge was developed by researchers from around the world and made public for us to share with you. AstroReality’s developers are working with our science advisor, J.R. Skok, PhD, a planetary scientist at the SETI Institute, to put the stories of EARTH into your hands.\n" +
                "\n" +
                "Here is Dr. Skok sharing a taste of just one of the many datasets that we can explore with EARTH.\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "Who is EARTH for?\n" +
                "\n" +
                "We made the EARTH experience incredibly easy to use for everyone—from schools who want to adopt the latest technology for their students, to everyday knowledge-seekers, to model collectors, and enthusiasts. \n" +
                "\n" +
                "Explore our planet's incredible structure!\n" +
                "Explore our planet's incredible structure!\n" +
                "EARTH specifications\n" +
                "\n" +
                "EARTH's specs at a glance.\n" +
                "EARTH's specs at a glance.\n" +
                "The model is incredibly detailed.\n" +
                "The model is incredibly detailed.\n" +
                "EARTH looks great anywhere.\n" +
                "EARTH looks great anywhere.\n" +
                "EARTH in the real world\n" +
                "\n" +
                "In conjunction with Wild Life Drawing we recently ran a one-off, around-the-EARTH drawing tour in London with live animals from various habitats around the globe— lizards from South America, skunks from Africa and tortoises from the Americas! \n" +
                "\n" +
                "We invited illustrators, journalists, and friends to meet, draw, and learn about some of the fascinating creatures we share our planet with.\n" +
                "\n" +
                "Lucky attendees of the event had the chance to try our EARTH and learn all the migration and habitats of animals past and present.\n" +
                "Lucky attendees of the event had the chance to try our EARTH and learn all the migration and habitats of animals past and present.\n" +
                "\"EARTH is unlike any other model—an encyclopedia for the modern world!\" —Jenny Webber, Founder of Wild Life Drawing\n" +
                "\"EARTH is unlike any other model—an encyclopedia for the modern world!\" —Jenny Webber, Founder of Wild Life Drawing\n" +
                "\"Seeing the cloud overlay using AR is beautiful and enriching.\" —Annabel Maguire, Studio Lune\n" +
                "\"Seeing the cloud overlay using AR is beautiful and enriching.\" —Annabel Maguire, Studio Lune\n" +
                "\"It's really incredible—the details of the continents, oceans, mountains, and more are all amazing.\" —Illustrator Alec Doherty\n" +
                "\"It's really incredible—the details of the continents, oceans, mountains, and more are all amazing.\" —Illustrator Alec Doherty\n" +
                "How EARTH is made\n" +
                "\n" +
                "We use poly resin density, 3D printing, and paint pigment ratios to create EARTH. Then, we refine our models to ensure the surface details—ocean, land, mountains—are clearly visible\n" +
                "\n" +
                "EARTH is made with an eco-friendly paint and production process. 3D printing is extremely precise, and levels down to 0.05 millimeters—printing error has a precision of 0.025 millimeters, printing resolution reaches 4000 DPI, and up to 0.006 millimeter per pixel. We then finish with a hand painted layer on every single unit.\n" +
                "\n" +
                "3D modeling of EARTH before printing.\n" +
                "3D modeling of EARTH before printing.\n" +
                "Working on EARTH's AI capabilities.\n" +
                "Working on EARTH's AI capabilities.\n" +
                "EARTH before the hand-painting process begins.\n" +
                "EARTH before the hand-painting process begins.\n" +
                "The EARTH unboxing experience!\n" +
                "The EARTH unboxing experience!\n" +
                "An unboxed EARTH with a small stand for display.\n" +
                "An unboxed EARTH with a small stand for display.\n" +
                "We have done this before!\n" +
                "\n" +
                "EARTH comes after our first successful project of a detailed replica of the moon—LUNAR. Hailed as “the best way to learn about the moon without actually visiting it” by Gizmodo—and praised by the likes of WIRED, Mashable, and The Next Web—LUNAR allowed users to explore and learn about the moon’s rocky surface.\n" +
                "\n" +
                "EARTH follows LUNAR’s AR experience, but this time with many new features and rich visualization from authentic datasets. Below is lunar and planetary scientist Georgiana Kramer explaining her experience with LUNAR.\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "Our first project, LUNAR, and the AR app.\n" +
                "Our first project, LUNAR, and the AR app.\n" +
                "Our LUNAR model in action!\n" +
                "Our LUNAR model in action!\n" +
                "EARTH will use the same tech as LUNAR, but with countless more features.\n" +
                "EARTH will use the same tech as LUNAR, but with countless more features.\n" +
                "LUNAR packaging and models.\n" +
                "LUNAR packaging and models.\n" +
                "Why we built EARTH\n" +
                "We’re passionate about our planet—it’s the only home we have. Unfortunately, Earth is going through irreversible changes that are forever changing the surface of everything we know—from global warming and glacial recession, to the extinction of its animals and wildlife.\n" +
                "\n" +
                "We hope that educating everyone about the effects we have on our planet from fossil fuels, pollution, and more will ignite a conscious change and passion for bettering the world as we know it.\n" +
                "\n" +
                "A highly accurate representation of our planet.\n" +
                "A highly accurate representation of our planet.\n" +
                "An unpainted EARTH.\n" +
                "An unpainted EARTH.\n" +
                "Check out the beautiful details!\n" +
                "Check out the beautiful details!\n" +
                "Who are we?\n" +
                "\n" +
                "The team behind EARTH is AstroReality—a collective of scientists, astronomy enthusiasts, designers, and tech geeks, who are deeply committed to using innovative and creative technology to shape the way people interact with science.\n" +
                "\n" +
                "\n" +
                "Rewards\n" +
                "\n" +
                "The first 150 backers of our reward tiers get a free EARTH AR Notebook!\n" +
                "\n" +
                "Check out the EARTH AR Notebook in action...\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "\n" +
                "Why Kickstarter?\n" +
                "\n" +
                "We love Kickstarter, because the community shares our passion for astronomy and science—which we've seen from the abundance of creative space projects across the platform. \n" +
                "\n" +
                "We believe information about the planet—past, present, and future—should be for everyone. To share our knowledge and passion about the planet with as many people as possible, we thought the democratic nature of a crowdfunding campaign would be a perfect fit. We're excited to bring together a community that celebrates learning about our planet using art and innovative technology!\n" +
                "\n" +
                "Thank you!");
        Item item14 = new Item(140,"FlashDrive—Stylized Arcade Racer","A stylized \"Mario Kart-like\" arcade racer with car customization, exciting power-ups, and detailed maps.",2,121.00,121.00,1,new Date(2017-1900,12,24),"Inspired by Mario Kart, Rocket league, and Sonic All Star racing, the aim of FlashDrive is to deliver a kart-racer feel with power-ups, drift, and boost while letting the player choose and customize their vehicle. Each map is unique and delivers a different experience every lap. Our maps include things like ooze geysers, volcanos, meteors, trains, shortcuts, rolling barrels and many more interactive objects.\n" +
                "\n" +
                "A tropical island map currently in development\n" +
                "A tropical island map currently in development\n" +
                "The main menu screen for FlashDrive\n" +
                "The main menu screen for FlashDrive\n" +
                "FlashDrive is also power-up heavy, and many powerups have quite the impact on the track. Our current power-ups include a giant snowball that grows in size as it rolls, a bowling ball that knocks down everything in its path, and many more.\n" +
                "\n" +
                "Narrowly dodging a bowling ball on the map playable in the demo\n" +
                "Narrowly dodging a bowling ball on the map playable in the demo\n" +
                "Also, we think it’s important to note:  \n" +
                "\n" +
                "We will have NO loot boxes, NO microtransactions, and NO paid dlcs.\n" +
                "\n" +
                " We will have consistent dev updates before release, and content updates after steam release.  \n" +
                "\n" +
                "Customize your vehicle with every color of the rainbow\n" +
                "Customize your vehicle with every color of the rainbow\n" +
                "Geysers spewing from the ground and canisters flying through the air in the Ooze Factory\n" +
                "Geysers spewing from the ground and canisters flying through the air in the Ooze Factory\n" +
                "\n" +
                "Talk to us! We'd love to hear your feedback. The best ways to contact us are via twitter or in our discord, which you'll get an invite for if you back the project! You can also check out our Youtube channel, which we've had for a while.\n" +
                "\n" +
                "Because we are a small team, everyone does a bit of everything.\n" +
                "\n" +
                "We'd also like to thank our long-time friend Bryce for making the current music in the game. We're still discussing whether or not to move forward together and create even more tracks, but at the current rate, it looks like we may :) He's only recently started making music in FL Studio but everything so far(especially the garage music) is very promising!  \n" +
                "\n" +
                "With the help of Noah, our friend Micah made the base models for the current cars in the game. You can expect more cars from him soon!\n" +
                "\n" +
                "Moving forward, there are many aspects of the game which we need to polish and there will most likely be a lot of bugs to fix. Content-wise, while the Kickstarter is going on we plan to add:\n" +
                "\n" +
                "More maps, more vehicles, better ai tuning, and customization options.\n" +
                "\n" +
                "Steam support, a lobby system, full controller support, power-up balancing, better engine sounds...\n" +
                "\n" +
                "And much more!\n" +
                "We have been working on this game part-time for almost a year now and have yet to show it off to anyone or get much of a reaction. For us, Kickstarter is an opportunity to receive feedback on the demo and many aspects of the game all while building a community. We value community deeply and would love to already have amassed a following before a steam launch. We think FlashDrive's multiplayer will play a large part in its success, and without a concurrent user base, joining online matches with other players will be much harder. However, the game will always still have single-player, ai, and easy ways to play with your friends.\n" +
                "\n" +
                "The three of us are all students, some with part-time jobs, and we know that making money off this game is not a guarantee. The Kickstarter goal was set not to pay ourselves at all, but to cover the essentials for releasing a complete and functional game on steam. The majority of the Kickstarter money will go toward music and servers. It would be our dream to make a living by developing games, however even while attending school and working other jobs we will never lay our passion for game dev down to rest. If the Kickstarter is not funded, we will still finish the game, just maybe behind schedule and not with all the features we originally had in mind.\n" +
                "\n" +
                "Thank you very much for checking out our project, it really means a lot : )\n" +
                "\n" +
                "Risks and challenges\n" +
                "\n" +
                "FlashDrive is an ambitious project, especially for a youthful team such as ourselves. However, we’ve gotten this far and amassed a large amount of knowledge and experience doing so. A year ago, when we talked about creating a game I had never recorded or mixed sounds before and Noah had never modeled buildings or cars in Blender.\n" +
                "\n" +
                "In terms of development, we have never taken the easy path and currently, we are only using 1 Unity asset from the asset store, which is the skybox. (which we may even make ourselves in the future) While we understand that bought assets can save a lot of time, we value learning and experience highly. Plus, creating something, even with the help of documentation and tutorials, is plenty fun and satisfying. \n" +
                "\n" +
                "We've been committed to this project since the start, and we know that we can deliver a fun racing experience that comes not from business models, but from the heart.");
        Item item15 = new Item(150,"Pico U. Brew Everything.","Brew beyond craft beer with a single appliance that crafts coffee, tea, kombucha, dry soda, fusion, energy, and health drinks.",1,3580.0,3580.0,0,new Date(2017-1900,2,1),"About\n" +
                "\n" +
                "With four wildly-successful Kickstarter campaigns under our belt (thanks for that!) we've perfected the technology to brew beer in the convenience of your own home. Making craft beer more accessible has always been our mission, but now, we’re going beyond beer. Get ready to make your wildest brewing dreams come true!\n" +
                "\n" +
                "\n" +
                "Meet Pico U, the world's first universal brewing machine. Pico U is a smart and compact brewing appliance that makes it easy to create your favorite craft beverages: From your first cup of coffee or tea in the morning to a kombucha or yerba mate afternoon pick-me-up to delicious pints of fresh craft beer as your end-of-day treat. Imagine sipping on an ice-cold black rice horchata or a crisp lemon cilantro dry soda that you created yourself. Pico U lets you brew just about anything!  \n" +
                "\n" +
                "\n" +
                "You just can't buy beverages as fresh as the ones you’ll make using your Pico U in your own kitchen—and that's what we love about the Pico U. If you can dream it, you can drink it!  \n" +
                "\n" +
                "Craft Beer  \n" +
                "\n" +
                "With the full-size step filter and 5-liter stainless steel brew keg, Pico U is ready to make delicious batches of craft beer. Load the PicoPak of your choice, add water, press the button, and you’re brewing!\n" +
                "\n" +
                "Coffee  \n" +
                "\n" +
                "Our newly-designed, pour-over basket turns your Pico into the ideal way to brew a perfect cup of coffee! Using your own fresh grounds, select your brew style and amount, and a fresh cup of coffee is just 90 seconds away.\n" +
                "\n" +
                "Fusion Beverages  \n" +
                "\n" +
                "Brew a refreshing pitcher of iced horchata, ginger lemon kombucha, citrus dry soda, yerba mate chai tea, vanilla cocoa cold brew, golden milk, and more with the Pico U! With the 1-liter glass Bruet and Mini Step Filter, you can brew practically any drink with our new PicoPak Mini recipe kits. Load a PicoPak Mini, connect the Bruet, and the Pico U can smartly brew a wide array of unique beverages.\n" +
                "\n" +

                "1. Use our Pledge Calculator to select your reward level, shipping, and any add-ons.  \n" +
                "\n" +
                "2. When you have your total, come back to Kickstarter and click \"Back this project\".\n" +
                "\n" +
                "3. Select your reward level again and enter the new total you got with the Pledge calculator.\n" +
                "\n" +

                "PicoPaks are fully compostable ingredient bundles designed to make an array of perfectly brewed beverages every time. Easily order your Paks online and they show up at your door, ready to brew!  \n" +
                "\n" +
                "Endless selection  \n" +
                "\n" +
                "We've partnered with hundreds of breweries from around the world to recreate their recipes so that you can enjoy world-class craft beer in your own home. Believe us, you will never get bored!\n" +
                "\n" +
                "\n" +
                "Customizable creativity\n" +
                "Creating your own recipes is easy with our online custom recipe crafter. You can choose from various hops, grains, and special ingredients to design your own tasty recipes! Our full-size PicoPaks are made for brewing beer and larger batches of beverages like cold brew coffee and kombucha. Our PicoPak Minis are perfect for smaller batches of fusion beverages like flavored coffee and health drinks.\n" +
                "\n" +
                "Good for the planet  \n" +
                "\n" +
                "At PicoBrew, we believe that convenience shouldn't come with an environmental cost. So, in designing the PicoPak, we knew plastic pods weren’t going to cut it. Our PicoPaks are biodegradable handmade ingredient kits made from 100% bagasse (sugar cane husk pulp) and completely compostable!\n" +
                "We’re leveraging our patented precision brewing technology to create the world’s first universal craft beverage brewing appliance. Here’s a look behind the scenes:   \n" +
                "\n" +
                "Temperature on Demand\n" +
                "\n" +
                "Pico U creates rich and flavorful beverages using precise temperature control. The thermal block takes water from the reservoir and brings it from room temp up to a customizable temperature. Water is distributed evenly over the top of the coffee, first blooming the grounds, then completing the brew for perfect results every time.\n" +
                "\n" +
                "\n" +
                "Fusion Control  \n" +
                "\n" +
                "When you load a PicoPak or PicoPak Mini into your Pico U, it sends the brewing mixture to the right place at the right time to accurately follow your preprogrammed recipe. The Pico U's multi-flow-manifold allows second-to-second control of what ingredients get infused into the brew.\n" +
                "\n" +
                "\n" +
                "With up to 4 stages in one recipe, Pico U can use high heat and flow rates to extract rich flavors, and then mellow things out to tease out subtle aromas without overheating delicate ingredients.  \n" +
                "\n" +
                "This powerful feature enables a multi-stage hops boil while brewing beer, and empowers a world of creativity when brewing fusion beverages from infused coffees and teas to kombucha and beyond.\n" +
                "\n" +
                "Better Beer Through Technology\n" +
                "\n" +
                "When you connect your keg and start brewing one of your own craft beer creations, or one of our award winning PicoPaks, there’s a lot going on behind the scenes. Powerful pumps and heating elements sanitize internal components and bring the water up to temperature, while an array of sensors monitor the process. An onboard processor maintains the heartbeat of the brew and connects to your online account to make sure all parts of the process are accurately delivered, just how you ordered them.\n" +
                "\n" +
                "\n" +
                "Meet Our Brewery Partners\n" +
                "\n" +
                "Our brewery partners inspire us every day! We’re proud to partner with award-winning breweries and help them share their best beers with new audiences from around the world. \n" +

                "Pico U is scheduled to begin shipping in January 2019. We’re on our fifth campaign now, and we feel confident in our ability to deliver a quality product. We are getting faster and faster at shipping new products and we promise to keep you in the loop along the way.  \n" +
                "\n" +
                "With Pico, you're not only brewing award-winning recipes from all over the globe, you're brewing them on award-winning equipment. PicoBrew has been the recipient of many prestigious awards and honors including 3 CES Innovation Awards, an IFA Best of Show, multiple Editor's Choice picks, and more. We've received so many awards in fact, that Fast Company recently named PicoBrew as the 10th Most Innovative Food Company in the World! Speaking of innovation, we have 5 patents on our technology and 12 additional patents pending.  \n" +
                "\n" +
                "We founded PicoBrew in 2010 with the vision of democratizing craft beer by allowing anyone to brew delicious craft beer, leveraging the expertise of the craft beer community. In 2013, we launched the world's first fully automatic all-grain beer brewing appliance, the PicoBrew Zymatic. After two more years of hard work we launched the PicoBrew Pico (Model S), the world's first true consumer countertop craft beer appliance, and invented the PicoPak compostable grains and hops recipe pack, as well as partnerships with hundreds of craft brewers around the world. In 2017, we unleashed our simplest and most affordable craft brewing appliance, the Pico Model C, which built on 7 years of pioneering and leadership in the craft beer space. This past year, we launched the Z Series, a professional-grade, all-grain brewing appliance line for professional brewers.  \n" +
                "\n" +
                "This is our fifth Kickstarter, and we’ve got nothing but love for our Kickstarter backers! You have helped provide funding and validation for our brewing innovation since Day 1. You’ve helped steer the feature sets of our products, our approach to customer support, and how we run our company. Thank you, backers!  \n" +
                "\n"+
                "PicoBrew is a team of 57 dedicated craft beer lovers and technologists (in that order) who cut their teeth in various respectable roles at big companies, but decided it was much better to work for a small company and make products that make people happy. We love delicious craft beverages and we love giving you the tools you need to make your own beverage magic.  \n" +
                "\n" +
                " --  \n" +
                "\n" +
                "Risks and challenges\n" +
                "\n" +
                "Our business centers on bringing the craft brewing experience home to you in the form of great-looking products that perform in unique ways. We self-manufactured our first two (Kickstarter-backed) products, the Zymatic and KegSmarts, so we have experienced the trials and tribulations of bringing complex products to market by ourselves. Since our first Pico model, we’ve been working with one of the world’s leading contract manufacturers. We’ve learned how to design for manufacture, build stringent factory tests, manage demand, and scale quickly. Even so, risks remain:\n" +
                "\n" +
                "MANUFACTURING: We’re doing some novel things to reduce cost, like designing and building our own low pressure brewing kegs with custom hose connectors. We’ve gotten pretty good at working with our factories to bring unique new products to market, but there are always manufacturing schedule risks for any product.\n" +
                "\n" +
                "FULFILLMENT: We experienced some challenges in shipping Zymatic, Kegsmarts, Pico, and Picopaks though our shipping partners—shipping large heavy packages and keeping the contents safe from us to you is not easy. Fortunately, we have learned a lot about how to make this work, but getting products in volume fulfilled worldwide is still non-trivial.\n" +
                "\n" +
                "INTERNATIONAL: Getting government regulatory approval for worldwide products remains a challenge, and again, part of the reason for partnering with Flex is that they’re really good at this.\n" +
                "\n" +
                "Help us make Pico U a reality with your pledge today!\n" +
                "\n" +
                "THANK YOU for your support!");
        Item item16 = new Item(160,"Molecularis - Reinventing the Flip Book","Remember flip books? We take them to the next level. Animation, coloring and optical illusion, all in one!s",2,400.00,100.00,0,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                ">>CLICK AQUÍ PARA VERSIÓN EN ESPAÑOL<<\n" +
                "\n" +
                "Hey Kickstarter! Two years ago, we came up with an idea about how to create a new kind of flip book. We wanted to upgrade the classic format and bring it to a whole new level, and this is the result:\n" +

                "\n" +
                "Molecularis is also an animated coloring book. You can use it in plenty of ways, by coloring, redrawing and varying its content with an endless number of possibilities. Use pencils, markers, watercolors, graphite, brushes, technical pens or whatever technique you prefer. \n" +
                "\n" +
                "\n" +
                "By alternating the colors gradually from one picture to the next and using your favorite color palette, you can not only give the sequences their very own personality, but also bring them to life – as you see them ‘move’ when you flip through the pages.\n" +

                "\n" +
                "Inside Molecularis, you’ll find a group of small and restless organisms that interact with each other as if they were being observed through a microscope.\n" +
                "\n" +
                "Like all flip books, Molecularis relies on the principle of persistence of vision, which in other words, is exactly what your eyes and brain do when you watch a movie. In a flip book, every picture varies gradually from one page to the next, so by flipping the pages with your thumb, they generate the illusion of movement. This simple technique has been around since 1868 and played an important role in the birth of cinema.\n" +
                "\n" +
                "Because the sequences are loop animated, after coloring or redrawing, you can create GIFs like this!\n" +
                "\n" +
                "\n" +
                "The sequences were designed and animated by Jossie Malis, co-founder of Flipboku and best known for his award-winning animated series Bendito Machine. Maybe you've come across this video from the first flip book we created for the show a couple of years ago. Find out more here.\n" +
                "\n" +
                "If you observe the flip book in closer detail, you will notice that the edges are cut in a specific way, so that you can swap between the different sequences. This is the key to the optical illusion that gives Molecularis its unique feature of showing you six different animations in just one flip book. You'll have a blast watching people's faces when they see Molecularis for the first time and try to understand how it works! :D\n" +
                "\n" +
                "And here's the secret: it all depends on the position of your thumb. You can switch between sequences by placing your thumb either in the upper corner, the center or the lower corner of the front edge of the book.\n" +
                "\n" +
                "As there are 3 sequences on each side of the book, the images are arranged alternately. This means that you will have sequences 1, 2 and 3 on one side and 4, 5 and 6 when you turn the book around. To proceed with the coloring simply follow each sequence by jumping every 3 pages. You will have better control of the coloring process if you follow each animated element in every sequence. \n" +
                "\n" +
                "Every single Molecularis is largely hand-produced and the whole process requires a number of steps that rely on careful supervision. We spent a lot of time testing different paper qualities and consulted with several experts until we found the perfect match: high quality 100% recycled heavy paper with a semi-rough surface and a nice smooth finish. It's suitable for all kinds of different techniques and prevents colors from passing through it. Each Molecularis comes with 180 pages (90 sheets). \n" +
                "\n" +
                " We have a weakness for good packaging, and that’s why we included a sleek slip case to keep your Molecularis safe after you use it. It prevents the pages from wearing out and by the way, it looks awesome on your shelf or wherever you want to keep it.\n" +
                "\n" +
                "As a perfect complement to Molecularis we have created a learning flip book for anyone who wants to try ‘freestyle’ animation::  \n" +
                "\n" +
                "\n" +
                "Blanko is a flip book that contains 320 blank pages on which you can animate whatever comes to your mind. If you're new to animation, learn how to get started with 6 of the basic principles we have included: squash and stretch, anticipation, ease in - ease out, arcs, timing and exaggeration. You can use both sides of the flip book.\n" +
                "\n" +
                "Watch this terrific animation by our good friend Nacho Rodríguez created on Blanko, featuring his character Mr. Coo:\n" +
                "\n" +
                " project video thumbnail PLAY\n" +
                "\n" +
                "Molecularis and Blanko make a great couple, that's why we have bundled them up in a practical and sleek protective sleeve. You can also choose between several combinations:");
        Item item17 = new Item(170,"Summer of Poetry","Take part in a season-long celebration featuring new poetry projects,",1,300.00,200.00,1,new Date(2017-1900,2,1),"Poetry, one of the world’s oldest art forms, is thriving online. With so many options for how to share work and engage with new audiences, it seems like there has never been a more exciting time to be a poet.\n" +
                "\n" +
                "Kickstarter is a place that connects poets and poetry publishers with readers who care deeply about their work. Since 2009, more than five hundred poetry projects have come to life with the help of the readers and poetry lovers on Kickstarter. We’ve seen chapbooks like No Experiences, anthologies like Anchored in Deep Water, translations such as Then Come Back (the lost poems of Pablo Neruda), a live performance series from Button Poetry, and even a poetic tarot deck.\n" +
                "\n" +
                "In June, we’re launching our first-ever Summer of Poetry, a season-long celebration featuring amazing new projects and poets for you to discover, poetry readings on Kickstarter Live, and events at our Brooklyn HQ. We want to spark conversations about what poetry is, who gets to write and publish it, how poetry sustains us, and how we can expand the world of poets and poetry.\n" +
                "\n" +
                "Photo by Lauren Renner\n" +
                "Photo by Lauren Renner\n" +
                "“Poetry surprises and deepens our sense of the ordinary. Poetry tells us that the world is full of wonder, revelation, consolation, and meaning.” —Tracy K. Smith, U.S. Poet Laureate\n" +
                "\n" +
                "We invite you to participate in these conversations with us by launching your own project sometime between June 1 and August 30. (Check out our video about how to raise funds and build community around your poetry project on Kickstarter.)\n" +
                "\n" +
                "Learn more about Kickstarter’s Summer of Poetry here, and be sure to send your project links, treatises, explorations, readings, videos, events, raw material in all its rawness, and any other ways you are celebrating poetry to poetry@kickstarter.com.\n" +
                "\n" +
                "We can’t wait to hear your voice.\n" +
                "\n");
        Item item18 = new Item(180,"A Tribute to Al Jarreau","Chris Walker & friends honor the incredible legacy of legendary vocalist Al Jarreaus",2,20859.0,20859.0,1,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "One of my earliest and fondest memories of my mentor and friend, Al Jarreau, was when I heard his music for the first time as a sophomore while attending the High School for the Performing and Visual Arts in Houston, TX. I was immediately drawn to the incredible variety of tones and the diverse vocal ability that emanated through each song, which captured my attention and took me on a lifelong journey into the many musical worlds of Al Jarreau. \n" +
                "\n" +
                "This musical journey included the genres of Orchestral, Jazz, Pop and R&B. Needless to say, I was hooked from day one and began to vocalize along with his many recordings. In addition, I learned how to play most of his songs simply by listening, which all originated from my training in both the church and from my father, Charles Walker Sr.’s gospel group, The Walker Brothers.  \n" +

                "As with any project, there is a possibility for risk. However, we have a great team of industry professionals collaborating on this project, and a solid executable plan for every part of the process. We are confident this project will be a successful endeavor, filled with love and joy. ");
        Item item19 = new Item(190,"Posti-plasto "," For the compost curious and master composters alike.",1,1460.0,1460.0,0,new Date(2017-1900,2,1)," Posti-plasto is... \n" +
                "\n" +
                "Contemporary and compelling. \n" +
                "Progessive and sustainable.\n" +
                "Educational and accessible.\n" +
                "\n" +
                "\n" +
                "What if we lived in a world where composting was everyday and throwing things in the trash was taboo? Posti-plasto is a citizen science project built to disappear. This is a limited release product to see how well a backyard compostable starch based plastic holds up in the home. Posti is on trend, and will be the perfect conversation starter in your home. Find the pledge that best fits your lifestyle and help us create a better tomorrow, today. \n" +
                "\n" +
                "The product we are launching is a backyard compostable air plant holder for your home.\n" +
                "\n" +
                "Vanessa Rey and Ariel Lynne are industrial designers and have created a starch based bioplastic that will breakdown in your backyard compost. We have found that nothing is truly timeless and many of our \"timeless designs\" end up in landfills.\n" +
                "\n" +
                "Create a Himalayan salt zen garden for your Posti\n" +
                "Create a Himalayan salt zen garden for your Posti\n" +
                "DIY Posti ~ Kits for making your own bioplastic at home!\n" +
                "DIY Posti ~ Kits for making your own bioplastic at home!\n" +
                "Get a family of Posti plant holders!\n" +
                "Get a family of Posti plant holders!\n" +
                "\n" +
                "Put a few drops of your favorite oils in your Posti\n" +
                "Put a few drops of your favorite oils in your Posti\n" +
                "As the seasons change, and the trends fade, you can then compost your Posti in numerous ways!\n" +
                "\n" +
                "We are working to create products that are fun and exciting for your home, but are good for the earth when their life with you is complete. \n" +
                "\n" +
                "\n" +
                "While we have been working on creating our special starch recipe for a year now, we do not know what to expect with the product long term. This is where you come in! \n" +
                "\n" +
                "What will happen to this plastic when it is in the dry desert climate of Arizona, or in the humidity of Florida? We all live in unique climates that vary, even from home to home in the same area. This is an exciting opportunity to learn a little bit more about chemical composition and contribute to the development of bioplastic! \n" +
                "\n" +
                "This product is not intended to last more than a season (2-4 months) and should be composted at the end of its life cycle. We will send out a survey in the fall to find out what sort of discoveries you made with your air plant holder, creating your own starch recipes, and other composting discoveries. We will share these findings on the podcast we plan to launch! \n" +
                "\n" +
                "The Posti-possibilities are endless!\n" +
                "\n" +
                "Contemporary Aesthetic \n" +
                "\n" +
                "We researched and found the most exciting color trends for Spring/Summer 2018. Posti-plasto's colors are bright & energetic and will make your home feel the same way.\n" +
                "\n" +
                "Posti comes in 3 colors: Quince Yellow, Pink Lemonade, & Cherry Tomato\n" +
                "Posti comes in 3 colors: Quince Yellow, Pink Lemonade, & Cherry Tomato\n" +
                "Our colors are a work in progress. We have been testing natural dyes and working to find the right recipe. All plant holders will have some variation in color due to the nature of the material. \n" +
                "\n" +
                "Posti-plasto form\n" +
                "\n" +
                "Merriam-Webster's Dictionary defines biomimicry as \"the imitation of natural biological designs or processes in engineering or invention.\" We looked to nature to find inspiration for the Posti plant holders.\n" +
                "\n" +
                "Worm Sketches\n" +
                "Worm Sketches\n" +
                "Concept Sketches for Plant Holders\n" +
                "Concept Sketches for Plant Holders\n" +
                "From concept sketch to reality\n" +
                "From concept sketch to reality\n" +
                "\n" +
                " What is composting actually?\n" +
                "\n" +
                "Composting in its simplest definition is organic matter breaking down and  returning to the earth. It causes no damage to the soil and when done correctly it improves the health of the earth.\n" +
                "\n" +
                "Organic matter and environment are key to successful composting.  \"Biodegradable\" and \"compostable\" items often do not degrade in landfills as the environment is unsuitable and contains large amounts of inorganic waste. This is why composting is so important! \n" +
                "\n" +
                "Purchasing sustainable goods alone is not enough to help keep our earth a beautiful place. We must learn how to refuse, reduce, reuse, recycle, and rot (or compost!) these items properly, and work to create change in systems at large. \n" +
                "\n" +
                "Why would you want to compost?\n" +
                "\n" +
                "Supplies much needed nutrient rich soil for farms across the country (which is important if you enjoy eating good tasting food)\n" +
                "To keep rotting waste out of landfills which create harmful methane gases\n" +
                "It reduces our need for chemical fertilizers\n" +
                "Lowers your carbon footprint\n" +
                "Helps retain moisture and supresses plant diseases and pests, which means you use less water on crops and gardens  — i.e. we all save money!\n" +
                "Cuts down on the smelly-ness of your garbage bins\n" +
                "How can I start?\n" +
                "\n" +
                "\n" +
                "Composting in your freezer: (free, easiest & city friendly) This is the simplest and easiest way to compost at home. You put a container with a lid on it in your freezer. Fill it with food scraps and when it's full drop it off at your local farmer's market (many cities offer free drop off at Farmer's markets). Here's a link to Chicago's free drop-offs.  \n" +
                "Pick-up Service: If you don't have time or space to start composting in your back yard, pick up services are a great option. There are many that do industrial composting which allows you to compost even more of your waste than a backyard bin alone. \n" +
                "Backyard Composting: This one may sound intimidating, but it really isn't as challenging as one might think. Click this link for easy step by step instructions.\n" +
                "\n" +
                "Cooking bioplastic!\n" +
                "Cooking bioplastic!\n" +
                " \n" +
                "Starch based plastics can be made in your kitchen at home and the recipes you can create are absolutely endless! We experimented with numerous different starches and bio based plasticizers (all ingredients were purchased in our local grocery store) until we achieved a recipe that could be cast in a 3d printed PLA mold.  \n" +
                "\n" +
                "We use PLA (Polylactic Acid) to create our molds because it is a biodegradable thermo plastic derived from corn starch that can be composted in industrial composting facilities.  If you purchase the kit, be sure your mold is being properly composted. \n" +
                "\n" +
                "Ariel Lynne and Vanessa Rey graduated together from the University of Illinois at Chicago receiving bachelor degrees in Industrial Design. They both have found collaboration to be the key to any successful project and luckily make a very good team. Ariel has an expert eye for aesthetics and gets the big picture. Vanessa is relentless researcher who has an eye for the details. \n" +
                "\n" +
                "They both studied in Copenhagen two summers ago, Vanessa focusing on renewable energy and Ariel focusing on furniture design. That's where they saw firsthand that good design can actually be environmentally responsible. This among -numerous- other experiences have led them to the creation of Posti-plasto.\n" +
                "\n" +
                "Posti-plasto is an experiment in merging sustainable materials, education, and aesthetics.  \n" +
                "\n" +
                "Risks and challenges\n" +
                "\n" +
                "Both Vanessa Rey and Ariel Lynne have successfully funded and fulfilled their own Kickstarters in the past and are confident in their abilities to deliver. The world is a hectic place though and we understand things do not always work out as planned. Our intent is to stick to the timeline and if any delays occur we will be as transparent as possible and keep you updated.\n" +
                "\n" +
                "The products listed on this page are working prototypes of our work and as such do not represent the exact product you will receive. As with everything handmade, colors might vary slightly and some imperfections may occur due to our bioplastic making process. If you get the kit you will truly understand the process in its entirety as well as the challenges and excitement that go along with it.\n" +
                "\n" +
                "DIY kits include instructions requiring the need for a stove and as such contents will be hot. There should always be an adult present when making this material.\n" +
                "\n" +
                "Posti is a gummy-type bioplastic and should never be consumed by pets, children, or adults. Please seek immediate help from your local physician if Posti is ingested accidentally.");
        Item item20 = new Item(200,"Great Coffee Should Be For Everyone","Democratizing great coffee with 'The Mix', an ever-evolving blend of the best, freshest beans, built to delight coffee lovers.",2,42903.00,42903.0,1,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "Being a coffee lover is often as frustrating as it is exhilarating.\n" +
                "\n" +
                "My co-founder Sumi and I started YES PLZ to help change this, and we're asking you to join with us as we take our next step.\n" +
                "Focusing all our experiences and our culinary ambitions into creating a single great product, we’re thrilled to introduce “The Mix”: an ever-evolving no-holds-barred, no-corners-cut blend of the best sourced beans, roasted with care, and delivered fresh to your door.\n" +
                "\n" +
                "The origins of “The Mix” begin with the project we did for Roy Choi and Daniel Patterson’s revolutionary fast food start-up LocoL. The challenge was to figure out how to make great coffee work at just $1 a cup, and we found that by being clever and controlling for waste, we could bring exceptionally crafted hot and cold coffee drinks to people at scale, without skimping on the quality of beans in our blend.\n" +
                "\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "That $1 cup was a big hit and caused a bigger stir than we could’ve anticipated. It challenged assumptions about what contexts great coffee could thrive in. It sparked a debate about the limitations of our third wave coffee movement's strategies (which I’ve long advocated) to move coffee drinkers toward paying higher prices to support higher quality, more sustainable coffee—against the need to reach a broader audience beyond the exclusionary, validation-seeking culinary burlesque that characterizes a lot of today’s high-end coffee bars.");




        carSet2.add(item11);
        carSet2.add(item12);
        carSet2.add(item13);
        carSet2.add(item14);
        carSet2.add(item15);
        carSet2.add(item16);
        carSet2.add(item17);
        carSet2.add(item18);
        carSet2.add(item19);
        carSet2.add(item20);

        i=11;
        for (Item item:carSet2){
            Item_Owner item_owner=new Item_Owner(i++,financier2.getUser_ID());
            session.save(item_owner);
        }

        session.save(financier2);
        session.save(item11);
        session.save(item12);
        session.save(item13);
        session.save(item14);
        session.save(item15);
        session.save(item16);
        session.save(item17);
        session.save(item18);
        session.save(item19);
        session.save(item20);


        //5.1 一号投资项目被两个支持者所支持
        i=1;
        for (Item item:carSet){
            Item_Supporters item_supporters=new Item_Supporters(i,investor2.getUser_ID(),50.0);
            Item it=session.get(Item.class,i++);
            it.setItem_StillDemandMoney(it.getItem_StillDemandMoney()-50.0);
            session.save(item_supporters);
            Query query=session.createQuery("update Item set Item_StillDemandMoney=? where Item_ID=?");
            query.setParameter(0,it.getItem_StillDemandMoney());
            query.setParameter(1,i);
            query.executeUpdate();
        }


        for (int j=11;j<=20;j++){
            Item_Supporters item_supporters=new Item_Supporters(j,investor1.getUser_ID(),50.0);
            Item it2=session.get(Item.class,j);
            it2.setItem_StillDemandMoney(it2.getItem_StillDemandMoney()-50.0);
            session.save(item_supporters);
            Query query=session.createQuery("update Item set Item_StillDemandMoney=? where Item_ID=?");
            query.setParameter(0,it2.getItem_StillDemandMoney());
            query.setParameter(1,j);
            query.executeUpdate();
            System.out.println(it2.getItem_StillDemandMoney());
        }




        //3号融资人
        Set<Item> carSet3 = new HashSet<>();
        Item item21 = new Item(241,"EARTH: An immersive AR/AI experience","A 3D-printed, hand-painted globe taking you through time to explore our planet’s geological changes, wildlife, weather patterns & more!",3,42903.00,42903.0,0,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "Being a coffee lover is often as frustrating as it is exhilarating.\n" +
                "\n" +
                "My co-founder Sumi and I started YES PLZ to help change this, and we're asking you to join with us as we take our next step.\n" +
                "Focusing all our experiences and our culinary ambitions into creating a single great product, we’re thrilled to introduce “The Mix”: an ever-evolving no-holds-barred, no-corners-cut blend of the best sourced beans, roasted with care, and delivered fresh to your door.\n" +
                "\n" +
                "The origins of “The Mix” begin with the project we did for Roy Choi and Daniel Patterson’s revolutionary fast food start-up LocoL. The challenge was to figure out how to make great coffee work at just $1 a cup, and we found that by being clever and controlling for waste, we could bring exceptionally crafted hot and cold coffee drinks to people at scale, without skimping on the quality of beans in our blend.\n" +
                "\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "That $1 cup was a big hit and caused a bigger stir than we could’ve anticipated. It challenged assumptions about what contexts great coffee could thrive in. It sparked a debate about the limitations of our third wave coffee movement's strategies (which I’ve long advocated) to move coffee drinkers toward paying higher prices to support higher quality, more sustainable coffee—against the need to reach a broader audience beyond the exclusionary, validation-seeking culinary burlesque that characterizes a lot of today’s high-end coffee bars.");

        Item item22 = new Item(178,"ROCK RUBBER 45s","A basketball, sneaker, and music cinematic odyssey experienced firsthand by authentic NYC culture orchestrator Bobbito García.",4,7789.00,7789.0,0,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "NYC native Bobbito García is a freelance creative who has put an indelible footprint on multiple urban movements. \n" +
                "\n" +
                "My co-founder Sumi and I started YES PLZ to help change this, and we're asking you to join with us as we take our next step.\n" +
                "Focusing all our experiences and our culinary ambitions into creating a single great product, we’re thrilled to introduce “The Mix”: an ever-evolving no-holds-barred, no-corners-cut blend of the best sourced beans, roasted with care, and delivered fresh to your door.\n" +
                "\n" +
                "The origins of “The Mix” begin with the project we did for Roy Choi and Daniel Patterson’s revolutionary fast food start-up LocoL. The challenge was to figure out how to make great coffee work at just $1 a cup, and we found that by being clever and controlling for waste, we could bring exceptionally crafted hot and cold coffee drinks to people at scale, without skimping on the quality of beans in our blend.\n" +
                "\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "That $1 cup was a big hit and caused a bigger stir than we could’ve anticipated. It challenged assumptions about what contexts great coffee could thrive in. It sparked a debate about the limitations of our third wave coffee movement's strategies (which I’ve long advocated) to move coffee drinkers toward paying higher prices to support higher quality, more sustainable coffee—against the need to reach a broader audience beyond the exclusionary, validation-seeking culinary burlesque that characterizes a lot of today’s high-end coffee bars.");

        Item item23 = new Item(217,"The Candy Store: A Documentary","The tale of a miraculous friendship between a young Iranian artist & the proprietor of the last all-night candy store in NYC.",5,789.00,789.0,0,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "Being a coffee lover is often as frustrating as it is exhilarating.\n" +
                "\n" +
                "My co-founder Sumi and I started YES PLZ to help change this, and we're asking you to join with us as we take our next step.\n" +
                "Focusing all our experiences and our culinary ambitions into creating a single great product, we’re thrilled to introduce “The Mix”: an ever-evolving no-holds-barred, no-corners-cut blend of the best sourced beans, roasted with care, and delivered fresh to your door.\n" +
                "\n" +
                "The origins of “The Mix” begin with the project we did for Roy Choi and Daniel Patterson’s revolutionary fast food start-up LocoL. The challenge was to figure out how to make great coffee work at just $1 a cup, and we found that by being clever and controlling for waste, we could bring exceptionally crafted hot and cold coffee drinks to people at scale, without skimping on the quality of beans in our blend.\n" +
                "\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "That $1 cup was a big hit and caused a bigger stir than we could’ve anticipated. It challenged assumptions about what contexts great coffee could thrive in. It sparked a debate about the limitations of our third wave coffee movement's strategies (which I’ve long advocated) to move coffee drinkers toward paying higher prices to support higher quality, more sustainable coffee—against the need to reach a broader audience beyond the exclusionary, validation-seeking culinary burlesque that characterizes a lot of today’s high-end coffee bars.");

        Item item24 = new Item(188,"Homemade","Homemade is a feature length documentary about a Force Recon Marine and his family after he returns from combat with hidden wounds.",3,42903.00,42903.0,0,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "Being a coffee lover is often as frustrating as it is exhilarating.\n" +
                "\n" +
                "My co-founder Sumi and I started YES PLZ to help change this, and we're asking you to join with us as we take our next step.\n" +
                "Focusing all our experiences and our culinary ambitions into creating a single great product, we’re thrilled to introduce “The Mix”: an ever-evolving no-holds-barred, no-corners-cut blend of the best sourced beans, roasted with care, and delivered fresh to your door.\n" +
                "\n" +
                "The origins of “The Mix” begin with the project we did for Roy Choi and Daniel Patterson’s revolutionary fast food start-up LocoL. The challenge was to figure out how to make great coffee work at just $1 a cup, and we found that by being clever and controlling for waste, we could bring exceptionally crafted hot and cold coffee drinks to people at scale, without skimping on the quality of beans in our blend.\n" +
                "\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "That $1 cup was a big hit and caused a bigger stir than we could’ve anticipated. It challenged assumptions about what contexts great coffee could thrive in. It sparked a debate about the limitations of our third wave coffee movement's strategies (which I’ve long advocated) to move coffee drinkers toward paying higher prices to support higher quality, more sustainable coffee—against the need to reach a broader audience beyond the exclusionary, validation-seeking culinary burlesque that characterizes a lot of today’s high-end coffee bars.");

        Item item25 = new Item(77,"I Know Catherine, The Log Lady (featuring David Lynch)","An authorized documentary about CATHERINE COULSON, best known as the LOG LADY in DAVID LYNCH & MARK FROST's TWIN PEAKS.s",4,42903.00,42903.0,0,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "Being a coffee lover is often as frustrating as it is exhilarating.\n" +
                "\n" +
                "My co-founder Sumi and I started YES PLZ to help change this, and we're asking you to join with us as we take our next step.\n" +
                "Focusing all our experiences and our culinary ambitions into creating a single great product, we’re thrilled to introduce “The Mix”: an ever-evolving no-holds-barred, no-corners-cut blend of the best sourced beans, roasted with care, and delivered fresh to your door.\n" +
                "\n" +
                "The origins of “The Mix” begin with the project we did for Roy Choi and Daniel Patterson’s revolutionary fast food start-up LocoL. The challenge was to figure out how to make great coffee work at just $1 a cup, and we found that by being clever and controlling for waste, we could bring exceptionally crafted hot and cold coffee drinks to people at scale, without skimping on the quality of beans in our blend.\n" +
                "\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "That $1 cup was a big hit and caused a bigger stir than we could’ve anticipated. It challenged assumptions about what contexts great coffee could thrive in. It sparked a debate about the limitations of our third wave coffee movement's strategies (which I’ve long advocated) to move coffee drinkers toward paying higher prices to support higher quality, more sustainable coffee—against the need to reach a broader audience beyond the exclusionary, validation-seeking culinary burlesque that characterizes a lot of today’s high-end coffee bars.");

        Item item26 = new Item(21,"¿Por qué la vida es así? La Película","Comedia documental que busca responder las preguntas que el mexicano se hace día a día, pero principalmente ¿Por qué la vida es así?",5,42903.00,42903.0,0,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "Being a coffee lover is often as frustrating as it is exhilarating.\n" +
                "\n" +
                "My co-founder Sumi and I started YES PLZ to help change this, and we're asking you to join with us as we take our next step.\n" +
                "Focusing all our experiences and our culinary ambitions into creating a single great product, we’re thrilled to introduce “The Mix”: an ever-evolving no-holds-barred, no-corners-cut blend of the best sourced beans, roasted with care, and delivered fresh to your door.\n" +
                "\n" +
                "The origins of “The Mix” begin with the project we did for Roy Choi and Daniel Patterson’s revolutionary fast food start-up LocoL. The challenge was to figure out how to make great coffee work at just $1 a cup, and we found that by being clever and controlling for waste, we could bring exceptionally crafted hot and cold coffee drinks to people at scale, without skimping on the quality of beans in our blend.\n" +
                "\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "That $1 cup was a big hit and caused a bigger stir than we could’ve anticipated. It challenged assumptions about what contexts great coffee could thrive in. It sparked a debate about the limitations of our third wave coffee movement's strategies (which I’ve long advocated) to move coffee drinkers toward paying higher prices to support higher quality, more sustainable coffee—against the need to reach a broader audience beyond the exclusionary, validation-seeking culinary burlesque that characterizes a lot of today’s high-end coffee bars.");


        Item item27 = new Item(41,"MESSIAHSEZ: The Messiah Lives in Brooklyn","A feature-length documentary about an absurdist internet persona and the search for genuine human connection.",3,42903.00,42903.0,0,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "Being a coffee lover is often as frustrating as it is exhilarating.\n" +
                "\n" +
                "My co-founder Sumi and I started YES PLZ to help change this, and we're asking you to join with us as we take our next step.\n" +
                "Focusing all our experiences and our culinary ambitions into creating a single great product, we’re thrilled to introduce “The Mix”: an ever-evolving no-holds-barred, no-corners-cut blend of the best sourced beans, roasted with care, and delivered fresh to your door.\n" +
                "\n" +
                "The origins of “The Mix” begin with the project we did for Roy Choi and Daniel Patterson’s revolutionary fast food start-up LocoL. The challenge was to figure out how to make great coffee work at just $1 a cup, and we found that by being clever and controlling for waste, we could bring exceptionally crafted hot and cold coffee drinks to people at scale, without skimping on the quality of beans in our blend.\n" +
                "\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "That $1 cup was a big hit and caused a bigger stir than we could’ve anticipated. It challenged assumptions about what contexts great coffee could thrive in. It sparked a debate about the limitations of our third wave coffee movement's strategies (which I’ve long advocated) to move coffee drinkers toward paying higher prices to support higher quality, more sustainable coffee—against the need to reach a broader audience beyond the exclusionary, validation-seeking culinary burlesque that characterizes a lot of today’s high-end coffee bars.");


        Item item28 = new Item(81,"OFF THE ROAD. Western musical movie","La región más silenciosa del desierto de Baja California será cruzada por la carrera de autos todo terreno más grande del mundo",3,42903.00,42903.0,0,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "Being a coffee lover is often as frustrating as it is exhilarating.\n" +
                "\n" +
                "My co-founder Sumi and I started YES PLZ to help change this, and we're asking you to join with us as we take our next step.\n" +
                "Focusing all our experiences and our culinary ambitions into creating a single great product, we’re thrilled to introduce “The Mix”: an ever-evolving no-holds-barred, no-corners-cut blend of the best sourced beans, roasted with care, and delivered fresh to your door.\n" +
                "\n" +
                "The origins of “The Mix” begin with the project we did for Roy Choi and Daniel Patterson’s revolutionary fast food start-up LocoL. The challenge was to figure out how to make great coffee work at just $1 a cup, and we found that by being clever and controlling for waste, we could bring exceptionally crafted hot and cold coffee drinks to people at scale, without skimping on the quality of beans in our blend.\n" +
                "\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "That $1 cup was a big hit and caused a bigger stir than we could’ve anticipated. It challenged assumptions about what contexts great coffee could thrive in. It sparked a debate about the limitations of our third wave coffee movement's strategies (which I’ve long advocated) to move coffee drinkers toward paying higher prices to support higher quality, more sustainable coffee—against the need to reach a broader audience beyond the exclusionary, validation-seeking culinary burlesque that characterizes a lot of today’s high-end coffee bars.");

        Item item29 = new Item(21,"Serendipia: An unexpected fortuitous discovery.","Serendipia, a performative documentary. Inspiring people to find their way and true happiness over what society trained you to achieve.",4,42903.00,42903.0,0,new Date(2017-1900,12,24),"About\n" +
                "\n" +
                "Being a coffee lover is often as frustrating as it is exhilarating.\n" +
                "\n" +
                "My co-founder Sumi and I started YES PLZ to help change this, and we're asking you to join with us as we take our next step.\n" +
                "Focusing all our experiences and our culinary ambitions into creating a single great product, we’re thrilled to introduce “The Mix”: an ever-evolving no-holds-barred, no-corners-cut blend of the best sourced beans, roasted with care, and delivered fresh to your door.\n" +
                "\n" +
                "The origins of “The Mix” begin with the project we did for Roy Choi and Daniel Patterson’s revolutionary fast food start-up LocoL. The challenge was to figure out how to make great coffee work at just $1 a cup, and we found that by being clever and controlling for waste, we could bring exceptionally crafted hot and cold coffee drinks to people at scale, without skimping on the quality of beans in our blend.\n" +
                "\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "Kind words and a bit of controversy in the NYTimes\n" +
                "That $1 cup was a big hit and caused a bigger stir than we could’ve anticipated. It challenged assumptions about what contexts great coffee could thrive in. It sparked a debate about the limitations of our third wave coffee movement's strategies (which I’ve long advocated) to move coffee drinkers toward paying higher prices to support higher quality, more sustainable coffee—against the need to reach a broader audience beyond the exclusionary, validation-seeking culinary burlesque that characterizes a lot of today’s high-end coffee bars.");







        carSet3.add(item21);
        carSet3.add(item22);
        carSet3.add(item23);
        carSet3.add(item24);
        carSet3.add(item25);
        carSet3.add(item26);
        carSet3.add(item27);
        carSet3.add(item28);
        carSet3.add(item29);

        i=21;
        for (Item item:carSet3){
            Item_Owner item_owner=new Item_Owner(i++,financier3.getUser_ID());
            session.save(item_owner);
            session.save(item_owner);
        }

        session.save(financier3);
        session.save(item21);
        session.save(item22);
        session.save(item23);
        session.save(item24);
        session.save(item25);
        session.save(item26);
        session.save(item27);
        session.save(item28);
        session.save(item29);

        Item_Comment item_comment1=new Item_Comment(1,"333","370203199610097917",new Date(2017-1900,12,24));
        Item_Comment item_comment2=new Item_Comment(1,"444","370203199610097917",new Date(2017-1900,12,24));
        Item_Comment item_comment3=new Item_Comment(1,"555","370203199610097917",new Date(2017-1900,12,24));
        Item_Comment item_comment4=new Item_Comment(1,"555","370203199610097917",new Date(2017-1900,12,24));
        Item_Comment item_comment5=new Item_Comment(1,"555","370203199610097917",new Date(2017-1900,12,24));
        Item_Comment item_comment6=new Item_Comment(1,"555","370203199610097917",new Date(2017-1900,12,24));
        session.save(item_comment1);
        session.save(item_comment2);
        session.save(item_comment3);
        session.save(item_comment4);
        session.save(item_comment5);
        session.save(item_comment6);
        session.close();
        HibernateUtils.getSessionFactory().close();
    }
}
