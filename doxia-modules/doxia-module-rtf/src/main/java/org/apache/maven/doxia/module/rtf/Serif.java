package org.apache.maven.doxia.module.rtf;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * @version $Id$
 */
class Serif
    extends FontMetrics
{
    static final CharMetrics[] metrics = {new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 333, 0, 130, -9, 238, 676 ), new CharMetrics( 408, 0, 77, 431, 331, 676 ),
        new CharMetrics( 500, 0, 5, 0, 496, 662 ), new CharMetrics( 500, 0, 44, -87, 457, 727 ),
        new CharMetrics( 833, 0, 61, -13, 772, 676 ), new CharMetrics( 778, 0, 42, -13, 750, 676 ),
        new CharMetrics( 333, 0, 79, 433, 218, 676 ), new CharMetrics( 333, 0, 48, -177, 304, 676 ),
        new CharMetrics( 333, 0, 29, -177, 285, 676 ), new CharMetrics( 500, 0, 69, 265, 432, 676 ),
        new CharMetrics( 564, 0, 30, 0, 534, 506 ), new CharMetrics( 250, 0, 56, -141, 195, 102 ),
        new CharMetrics( 333, 0, 39, 194, 285, 257 ), new CharMetrics( 250, 0, 70, -11, 181, 100 ),
        new CharMetrics( 278, 0, -9, -14, 287, 676 ), new CharMetrics( 500, 0, 24, -14, 476, 676 ),
        new CharMetrics( 500, 0, 111, 0, 394, 676 ), new CharMetrics( 500, 0, 30, 0, 475, 676 ),
        new CharMetrics( 500, 0, 43, -14, 431, 676 ), new CharMetrics( 500, 0, 12, 0, 472, 676 ),
        new CharMetrics( 500, 0, 32, -14, 438, 688 ), new CharMetrics( 500, 0, 34, -14, 468, 684 ),
        new CharMetrics( 500, 0, 20, -8, 449, 662 ), new CharMetrics( 500, 0, 56, -14, 445, 676 ),
        new CharMetrics( 500, 0, 30, -22, 459, 676 ), new CharMetrics( 278, 0, 81, -11, 192, 459 ),
        new CharMetrics( 278, 0, 80, -141, 219, 459 ), new CharMetrics( 564, 0, 28, -8, 536, 514 ),
        new CharMetrics( 564, 0, 30, 120, 534, 386 ), new CharMetrics( 564, 0, 28, -8, 536, 514 ),
        new CharMetrics( 444, 0, 68, -8, 414, 676 ), new CharMetrics( 921, 0, 116, -14, 809, 676 ),
        new CharMetrics( 722, 0, 15, 0, 706, 674 ), new CharMetrics( 667, 0, 17, 0, 593, 662 ),
        new CharMetrics( 667, 0, 28, -14, 633, 676 ), new CharMetrics( 722, 0, 16, 0, 685, 662 ),
        new CharMetrics( 611, 0, 12, 0, 597, 662 ), new CharMetrics( 556, 0, 12, 0, 546, 662 ),
        new CharMetrics( 722, 0, 32, -14, 709, 676 ), new CharMetrics( 722, 0, 19, 0, 702, 662 ),
        new CharMetrics( 333, 0, 18, 0, 315, 662 ), new CharMetrics( 389, 0, 10, -14, 370, 662 ),
        new CharMetrics( 722, 0, 34, 0, 723, 662 ), new CharMetrics( 611, 0, 12, 0, 598, 662 ),
        new CharMetrics( 889, 0, 12, 0, 863, 662 ), new CharMetrics( 722, 0, 12, -11, 707, 662 ),
        new CharMetrics( 722, 0, 34, -14, 688, 676 ), new CharMetrics( 556, 0, 16, 0, 542, 662 ),
        new CharMetrics( 722, 0, 34, -178, 701, 676 ), new CharMetrics( 667, 0, 17, 0, 659, 662 ),
        new CharMetrics( 556, 0, 42, -14, 491, 676 ), new CharMetrics( 611, 0, 17, 0, 593, 662 ),
        new CharMetrics( 722, 0, 14, -14, 705, 662 ), new CharMetrics( 722, 0, 16, -11, 697, 662 ),
        new CharMetrics( 944, 0, 5, -11, 932, 662 ), new CharMetrics( 722, 0, 10, 0, 704, 662 ),
        new CharMetrics( 722, 0, 22, 0, 703, 662 ), new CharMetrics( 611, 0, 9, 0, 597, 662 ),
        new CharMetrics( 333, 0, 88, -156, 299, 662 ), new CharMetrics( 278, 0, -9, -14, 287, 676 ),
        new CharMetrics( 333, 0, 34, -156, 245, 662 ), new CharMetrics( 469, 0, 24, 297, 446, 662 ),
        new CharMetrics( 500, 0, 0, -125, 500, -75 ), new CharMetrics( 333, 0, 115, 433, 254, 676 ),
        new CharMetrics( 444, 0, 37, -10, 442, 460 ), new CharMetrics( 500, 0, 3, -10, 468, 683 ),
        new CharMetrics( 444, 0, 25, -10, 412, 460 ), new CharMetrics( 500, 0, 27, -10, 491, 683 ),
        new CharMetrics( 444, 0, 25, -10, 424, 460 ), new CharMetrics( 333, 0, 20, 0, 383, 683 ),
        new CharMetrics( 500, 0, 28, -218, 470, 460 ), new CharMetrics( 500, 0, 9, 0, 487, 683 ),
        new CharMetrics( 278, 0, 16, 0, 253, 683 ), new CharMetrics( 278, 0, -70, -218, 194, 683 ),
        new CharMetrics( 500, 0, 7, 0, 505, 683 ), new CharMetrics( 278, 0, 19, 0, 257, 683 ),
        new CharMetrics( 778, 0, 16, 0, 775, 460 ), new CharMetrics( 500, 0, 16, 0, 485, 460 ),
        new CharMetrics( 500, 0, 29, -10, 470, 460 ), new CharMetrics( 500, 0, 5, -217, 470, 460 ),
        new CharMetrics( 500, 0, 24, -217, 488, 460 ), new CharMetrics( 333, 0, 5, 0, 335, 460 ),
        new CharMetrics( 389, 0, 51, -10, 348, 460 ), new CharMetrics( 278, 0, 13, -10, 279, 579 ),
        new CharMetrics( 500, 0, 9, -10, 479, 450 ), new CharMetrics( 500, 0, 19, -14, 477, 450 ),
        new CharMetrics( 722, 0, 21, -14, 694, 450 ), new CharMetrics( 500, 0, 17, 0, 479, 450 ),
        new CharMetrics( 500, 0, 14, -218, 475, 450 ), new CharMetrics( 444, 0, 27, 0, 418, 450 ),
        new CharMetrics( 480, 0, 100, -181, 350, 680 ), new CharMetrics( 200, 0, 67, -14, 133, 676 ),
        new CharMetrics( 480, 0, 130, -181, 380, 680 ), new CharMetrics( 541, 0, 40, 183, 502, 323 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 278, 0, 16, 0, 253, 460 ),
        new CharMetrics( 333, 0, 19, 507, 242, 678 ), new CharMetrics( 333, 0, 93, 507, 317, 678 ),
        new CharMetrics( 333, 0, 11, 507, 322, 674 ), new CharMetrics( 333, 0, 1, 532, 331, 638 ),
        new CharMetrics( 333, 0, 11, 547, 322, 601 ), new CharMetrics( 333, 0, 26, 507, 307, 664 ),
        new CharMetrics( 333, 0, 118, 523, 216, 623 ), new CharMetrics( 333, 0, 18, 523, 315, 623 ),
        new CharMetrics( 250, 0, 0, 0, 0, 0 ), new CharMetrics( 333, 0, 67, 512, 266, 711 ),
        new CharMetrics( 333, 0, 52, -215, 261, 0 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 333, 0, -3, 507, 377, 678 ), new CharMetrics( 333, 0, 64, -165, 249, 0 ),
        new CharMetrics( 333, 0, 11, 507, 322, 674 ), new CharMetrics( 250, 0, 0, 0, 0, 0 ),
        new CharMetrics( 333, 0, 97, -218, 205, 467 ), new CharMetrics( 500, 0, 53, -138, 448, 579 ),
        new CharMetrics( 500, 0, 12, -8, 490, 676 ), new CharMetrics( 500, 0, -22, 58, 522, 602 ),
        new CharMetrics( 500, 0, -53, 0, 512, 662 ), new CharMetrics( 200, 0, 67, -14, 133, 676 ),
        new CharMetrics( 500, 0, 70, -148, 426, 676 ), new CharMetrics( 333, 0, 18, 523, 315, 623 ),
        new CharMetrics( 760, 0, 38, -14, 722, 676 ), new CharMetrics( 276, 0, 4, 394, 270, 676 ),
        new CharMetrics( 500, 0, 42, 33, 456, 416 ), new CharMetrics( 564, 0, 30, 108, 534, 386 ),
        new CharMetrics( 333, 0, 39, 194, 285, 257 ), new CharMetrics( 760, 0, 38, -14, 722, 676 ),
        new CharMetrics( 333, 0, 11, 547, 322, 601 ), new CharMetrics( 400, 0, 57, 390, 343, 676 ),
        new CharMetrics( 564, 0, 30, 0, 534, 506 ), new CharMetrics( 300, 0, 1, 270, 296, 676 ),
        new CharMetrics( 300, 0, 15, 262, 291, 676 ), new CharMetrics( 333, 0, 93, 507, 317, 678 ),
        new CharMetrics( 500, 0, 36, -218, 512, 450 ), new CharMetrics( 453, 0, -22, -154, 450, 662 ),
        new CharMetrics( 250, 0, 70, 199, 181, 310 ), new CharMetrics( 333, 0, 52, -215, 261, 0 ),
        new CharMetrics( 300, 0, 57, 270, 248, 676 ), new CharMetrics( 310, 0, 6, 394, 304, 676 ),
        new CharMetrics( 500, 0, 44, 33, 458, 416 ), new CharMetrics( 750, 0, 37, -14, 718, 676 ),
        new CharMetrics( 750, 0, 31, -14, 746, 676 ), new CharMetrics( 750, 0, 15, -14, 718, 676 ),
        new CharMetrics( 444, 0, 30, -218, 376, 466 ), new CharMetrics( 722, 0, 15, 0, 706, 890 ),
        new CharMetrics( 722, 0, 15, 0, 706, 890 ), new CharMetrics( 722, 0, 15, 0, 706, 886 ),
        new CharMetrics( 722, 0, 15, 0, 706, 850 ), new CharMetrics( 722, 0, 15, 0, 706, 835 ),
        new CharMetrics( 722, 0, 15, 0, 706, 898 ), new CharMetrics( 889, 0, 0, 0, 863, 662 ),
        new CharMetrics( 667, 0, 28, -215, 633, 676 ), new CharMetrics( 611, 0, 12, 0, 597, 890 ),
        new CharMetrics( 611, 0, 12, 0, 597, 890 ), new CharMetrics( 611, 0, 12, 0, 597, 886 ),
        new CharMetrics( 611, 0, 12, 0, 597, 835 ), new CharMetrics( 333, 0, 18, 0, 315, 890 ),
        new CharMetrics( 333, 0, 18, 0, 317, 890 ), new CharMetrics( 333, 0, 11, 0, 322, 886 ),
        new CharMetrics( 333, 0, 18, 0, 315, 835 ), new CharMetrics( 722, 0, 16, 0, 685, 662 ),
        new CharMetrics( 722, 0, 12, -11, 707, 850 ), new CharMetrics( 722, 0, 34, -14, 688, 890 ),
        new CharMetrics( 722, 0, 34, -14, 688, 890 ), new CharMetrics( 722, 0, 34, -14, 688, 886 ),
        new CharMetrics( 722, 0, 34, -14, 688, 850 ), new CharMetrics( 722, 0, 34, -14, 688, 835 ),
        new CharMetrics( 564, 0, 38, 8, 527, 497 ), new CharMetrics( 722, 0, 34, -80, 688, 734 ),
        new CharMetrics( 722, 0, 14, -14, 705, 890 ), new CharMetrics( 722, 0, 14, -14, 705, 890 ),
        new CharMetrics( 722, 0, 14, -14, 705, 886 ), new CharMetrics( 722, 0, 14, -14, 705, 835 ),
        new CharMetrics( 722, 0, 22, 0, 703, 890 ), new CharMetrics( 556, 0, 16, 0, 542, 662 ),
        new CharMetrics( 500, 0, 12, -9, 468, 683 ), new CharMetrics( 444, 0, 37, -10, 442, 678 ),
        new CharMetrics( 444, 0, 37, -10, 442, 678 ), new CharMetrics( 444, 0, 37, -10, 442, 674 ),
        new CharMetrics( 444, 0, 37, -10, 442, 638 ), new CharMetrics( 444, 0, 37, -10, 442, 623 ),
        new CharMetrics( 444, 0, 37, -10, 442, 711 ), new CharMetrics( 667, 0, 38, -10, 632, 460 ),
        new CharMetrics( 444, 0, 25, -215, 412, 460 ), new CharMetrics( 444, 0, 25, -10, 424, 678 ),
        new CharMetrics( 444, 0, 25, -10, 424, 678 ), new CharMetrics( 444, 0, 25, -10, 424, 674 ),
        new CharMetrics( 444, 0, 25, -10, 424, 623 ), new CharMetrics( 278, 0, -8, 0, 253, 678 ),
        new CharMetrics( 278, 0, 16, 0, 290, 678 ), new CharMetrics( 278, 0, -16, 0, 295, 674 ),
        new CharMetrics( 278, 0, -9, 0, 288, 623 ), new CharMetrics( 500, 0, 29, -10, 471, 686 ),
        new CharMetrics( 500, 0, 16, 0, 485, 638 ), new CharMetrics( 500, 0, 29, -10, 470, 678 ),
        new CharMetrics( 500, 0, 29, -10, 470, 678 ), new CharMetrics( 500, 0, 29, -10, 470, 674 ),
        new CharMetrics( 500, 0, 29, -10, 470, 638 ), new CharMetrics( 500, 0, 29, -10, 470, 623 ),
        new CharMetrics( 564, 0, 30, -10, 534, 516 ), new CharMetrics( 500, 0, 29, -112, 470, 551 ),
        new CharMetrics( 500, 0, 9, -10, 479, 678 ), new CharMetrics( 500, 0, 9, -10, 479, 678 ),
        new CharMetrics( 500, 0, 9, -10, 479, 674 ), new CharMetrics( 500, 0, 9, -10, 479, 623 ),
        new CharMetrics( 500, 0, 14, -218, 475, 678 ), new CharMetrics( 500, 0, 5, -217, 470, 683 ),
        new CharMetrics( 500, 0, 14, -218, 475, 623 )};

    Serif()
    {
        super( false, 683, -217, new CharMetrics( 0, 0, -168, -218, 1000, 898 ), metrics );
    }
}
