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
class MonospaceBold
    extends FontMetrics
{
    static final CharMetrics[] metrics = {new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 202, -15, 398, 572 ), new CharMetrics( 600, 0, 135, 277, 465, 562 ),
        new CharMetrics( 600, 0, 56, -45, 544, 651 ), new CharMetrics( 600, 0, 82, -126, 519, 666 ),
        new CharMetrics( 600, 0, 5, -15, 595, 616 ), new CharMetrics( 600, 0, 36, -15, 546, 543 ),
        new CharMetrics( 600, 0, 171, 277, 423, 562 ), new CharMetrics( 600, 0, 219, -102, 461, 616 ),
        new CharMetrics( 600, 0, 139, -102, 381, 616 ), new CharMetrics( 600, 0, 91, 219, 509, 601 ),
        new CharMetrics( 600, 0, 71, 39, 529, 478 ), new CharMetrics( 600, 0, 123, -111, 393, 174 ),
        new CharMetrics( 600, 0, 100, 203, 500, 313 ), new CharMetrics( 600, 0, 192, -15, 408, 171 ),
        new CharMetrics( 600, 0, 98, -77, 502, 626 ), new CharMetrics( 600, 0, 87, -15, 513, 616 ),
        new CharMetrics( 600, 0, 81, 0, 539, 616 ), new CharMetrics( 600, 0, 61, 0, 499, 616 ),
        new CharMetrics( 600, 0, 63, -15, 501, 616 ), new CharMetrics( 600, 0, 53, 0, 507, 616 ),
        new CharMetrics( 600, 0, 70, -15, 521, 601 ), new CharMetrics( 600, 0, 90, -15, 521, 616 ),
        new CharMetrics( 600, 0, 55, 0, 494, 601 ), new CharMetrics( 600, 0, 83, -15, 517, 616 ),
        new CharMetrics( 600, 0, 79, -15, 510, 616 ), new CharMetrics( 600, 0, 191, -15, 407, 425 ),
        new CharMetrics( 600, 0, 123, -111, 408, 425 ), new CharMetrics( 600, 0, 66, 15, 523, 501 ),
        new CharMetrics( 600, 0, 71, 118, 529, 398 ), new CharMetrics( 600, 0, 77, 15, 534, 501 ),
        new CharMetrics( 600, 0, 98, -14, 501, 580 ), new CharMetrics( 600, 0, 16, -15, 584, 616 ),
        new CharMetrics( 600, 0, -9, 0, 609, 562 ), new CharMetrics( 600, 0, 30, 0, 573, 562 ),
        new CharMetrics( 600, 0, 22, -18, 560, 580 ), new CharMetrics( 600, 0, 30, 0, 594, 562 ),
        new CharMetrics( 600, 0, 25, 0, 560, 562 ), new CharMetrics( 600, 0, 39, 0, 570, 562 ),
        new CharMetrics( 600, 0, 22, -18, 594, 580 ), new CharMetrics( 600, 0, 20, 0, 580, 562 ),
        new CharMetrics( 600, 0, 77, 0, 523, 562 ), new CharMetrics( 600, 0, 37, -18, 601, 562 ),
        new CharMetrics( 600, 0, 21, 0, 599, 562 ), new CharMetrics( 600, 0, 39, 0, 578, 562 ),
        new CharMetrics( 600, 0, -2, 0, 602, 562 ), new CharMetrics( 600, 0, 8, -12, 610, 562 ),
        new CharMetrics( 600, 0, 22, -18, 578, 580 ), new CharMetrics( 600, 0, 48, 0, 559, 562 ),
        new CharMetrics( 600, 0, 32, -138, 578, 580 ), new CharMetrics( 600, 0, 24, 0, 599, 562 ),
        new CharMetrics( 600, 0, 47, -22, 553, 582 ), new CharMetrics( 600, 0, 21, 0, 579, 562 ),
        new CharMetrics( 600, 0, 4, -18, 596, 562 ), new CharMetrics( 600, 0, -13, 0, 613, 562 ),
        new CharMetrics( 600, 0, -18, 0, 618, 562 ), new CharMetrics( 600, 0, 12, 0, 588, 562 ),
        new CharMetrics( 600, 0, 12, 0, 589, 562 ), new CharMetrics( 600, 0, 62, 0, 539, 562 ),
        new CharMetrics( 600, 0, 245, -102, 475, 616 ), new CharMetrics( 600, 0, 99, -77, 503, 626 ),
        new CharMetrics( 600, 0, 125, -102, 355, 616 ), new CharMetrics( 600, 0, 108, 250, 492, 616 ),
        new CharMetrics( 600, 0, 0, -125, 600, -75 ), new CharMetrics( 600, 0, 178, 277, 428, 562 ),
        new CharMetrics( 600, 0, 35, -15, 570, 454 ), new CharMetrics( 600, 0, 0, -15, 584, 626 ),
        new CharMetrics( 600, 0, 40, -15, 545, 459 ), new CharMetrics( 600, 0, 20, -15, 591, 626 ),
        new CharMetrics( 600, 0, 40, -15, 563, 454 ), new CharMetrics( 600, 0, 83, 0, 547, 626 ),
        new CharMetrics( 600, 0, 30, -146, 580, 454 ), new CharMetrics( 600, 0, 5, 0, 592, 626 ),
        new CharMetrics( 600, 0, 77, 0, 523, 658 ), new CharMetrics( 600, 0, 63, -146, 440, 658 ),
        new CharMetrics( 600, 0, 20, 0, 585, 626 ), new CharMetrics( 600, 0, 77, 0, 523, 626 ),
        new CharMetrics( 600, 0, -22, 0, 626, 454 ), new CharMetrics( 600, 0, 18, 0, 592, 454 ),
        new CharMetrics( 600, 0, 30, -15, 570, 454 ), new CharMetrics( 600, 0, -1, -142, 570, 454 ),
        new CharMetrics( 600, 0, 20, -142, 591, 454 ), new CharMetrics( 600, 0, 47, 0, 580, 454 ),
        new CharMetrics( 600, 0, 68, -17, 535, 459 ), new CharMetrics( 600, 0, 47, -15, 532, 562 ),
        new CharMetrics( 600, 0, -1, -15, 569, 439 ), new CharMetrics( 600, 0, -1, 0, 601, 439 ),
        new CharMetrics( 600, 0, -18, 0, 618, 439 ), new CharMetrics( 600, 0, 6, 0, 594, 439 ),
        new CharMetrics( 600, 0, -4, -142, 601, 439 ), new CharMetrics( 600, 0, 81, 0, 520, 439 ),
        new CharMetrics( 600, 0, 160, -102, 464, 616 ), new CharMetrics( 600, 0, 255, -250, 345, 750 ),
        new CharMetrics( 600, 0, 136, -102, 440, 616 ), new CharMetrics( 600, 0, 71, 153, 530, 356 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 77, 0, 523, 439 ),
        new CharMetrics( 600, 0, 132, 508, 395, 661 ), new CharMetrics( 600, 0, 205, 508, 468, 661 ),
        new CharMetrics( 600, 0, 103, 483, 497, 657 ), new CharMetrics( 600, 0, 89, 493, 512, 636 ),
        new CharMetrics( 600, 0, 88, 505, 512, 585 ), new CharMetrics( 600, 0, 83, 468, 517, 631 ),
        new CharMetrics( 600, 0, 230, 485, 370, 625 ), new CharMetrics( 600, 0, 128, 485, 472, 625 ),
        new CharMetrics( 600, 0, 0, 0, 0, 0 ), new CharMetrics( 600, 0, 198, 481, 402, 678 ),
        new CharMetrics( 600, 0, 205, -206, 387, 0 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 68, 488, 588, 661 ), new CharMetrics( 600, 0, 169, -199, 367, 0 ),
        new CharMetrics( 600, 0, 103, 493, 497, 667 ), new CharMetrics( 600, 0, 0, 0, 0, 0 ),
        new CharMetrics( 600, 0, 202, -146, 398, 449 ), new CharMetrics( 600, 0, 66, -49, 518, 614 ),
        new CharMetrics( 600, 0, 72, -28, 558, 611 ), new CharMetrics( 600, 0, 54, 49, 546, 517 ),
        new CharMetrics( 600, 0, 10, 0, 590, 562 ), new CharMetrics( 600, 0, 255, -175, 345, 675 ),
        new CharMetrics( 600, 0, 83, -70, 517, 580 ), new CharMetrics( 600, 0, 128, 485, 472, 625 ),
        new CharMetrics( 600, 0, 0, -18, 600, 580 ), new CharMetrics( 600, 0, 147, 196, 453, 580 ),
        new CharMetrics( 600, 0, 8, 70, 553, 446 ), new CharMetrics( 600, 0, 71, 103, 529, 413 ),
        new CharMetrics( 600, 0, 100, 203, 500, 313 ), new CharMetrics( 600, 0, 0, -18, 600, 580 ),
        new CharMetrics( 600, 0, 88, 505, 512, 585 ), new CharMetrics( 600, 0, 86, 243, 474, 616 ),
        new CharMetrics( 600, 0, 71, 24, 529, 515 ), new CharMetrics( 600, 0, 143, 230, 436, 616 ),
        new CharMetrics( 600, 0, 138, 222, 433, 616 ), new CharMetrics( 600, 0, 205, 508, 468, 661 ),
        new CharMetrics( 600, 0, -1, -142, 569, 439 ), new CharMetrics( 600, 0, 6, -70, 576, 580 ),
        new CharMetrics( 600, 0, 196, 165, 404, 351 ), new CharMetrics( 600, 0, 205, -206, 387, 0 ),
        new CharMetrics( 600, 0, 153, 230, 447, 616 ), new CharMetrics( 600, 0, 147, 196, 453, 580 ),
        new CharMetrics( 600, 0, 47, 70, 592, 446 ), new CharMetrics( 600, 0, -56, -60, 656, 661 ),
        new CharMetrics( 600, 0, -47, -60, 648, 661 ), new CharMetrics( 600, 0, -47, -60, 648, 661 ),
        new CharMetrics( 600, 0, 99, -146, 502, 449 ), new CharMetrics( 600, 0, -9, 0, 609, 784 ),
        new CharMetrics( 600, 0, -9, 0, 609, 784 ), new CharMetrics( 600, 0, -9, 0, 609, 780 ),
        new CharMetrics( 600, 0, -9, 0, 609, 759 ), new CharMetrics( 600, 0, -9, 0, 609, 748 ),
        new CharMetrics( 600, 0, -9, 0, 609, 801 ), new CharMetrics( 600, 0, -29, 0, 602, 562 ),
        new CharMetrics( 600, 0, 22, -206, 560, 580 ), new CharMetrics( 600, 0, 25, 0, 560, 784 ),
        new CharMetrics( 600, 0, 25, 0, 560, 784 ), new CharMetrics( 600, 0, 25, 0, 560, 780 ),
        new CharMetrics( 600, 0, 25, 0, 560, 748 ), new CharMetrics( 600, 0, 77, 0, 523, 784 ),
        new CharMetrics( 600, 0, 77, 0, 523, 784 ), new CharMetrics( 600, 0, 77, 0, 523, 780 ),
        new CharMetrics( 600, 0, 77, 0, 523, 748 ), new CharMetrics( 600, 0, 30, 0, 594, 562 ),
        new CharMetrics( 600, 0, 8, -12, 610, 759 ), new CharMetrics( 600, 0, 22, -18, 578, 784 ),
        new CharMetrics( 600, 0, 22, -18, 578, 784 ), new CharMetrics( 600, 0, 22, -18, 578, 780 ),
        new CharMetrics( 600, 0, 22, -18, 578, 759 ), new CharMetrics( 600, 0, 22, -18, 578, 748 ),
        new CharMetrics( 600, 0, 81, 39, 520, 478 ), new CharMetrics( 600, 0, 22, -22, 578, 584 ),
        new CharMetrics( 600, 0, 4, -18, 596, 784 ), new CharMetrics( 600, 0, 4, -18, 596, 784 ),
        new CharMetrics( 600, 0, 4, -18, 596, 780 ), new CharMetrics( 600, 0, 4, -18, 596, 748 ),
        new CharMetrics( 600, 0, 12, 0, 589, 784 ), new CharMetrics( 600, 0, 48, 0, 557, 562 ),
        new CharMetrics( 600, 0, 22, -15, 596, 626 ), new CharMetrics( 600, 0, 35, -15, 570, 661 ),
        new CharMetrics( 600, 0, 35, -15, 570, 661 ), new CharMetrics( 600, 0, 35, -15, 570, 657 ),
        new CharMetrics( 600, 0, 35, -15, 570, 636 ), new CharMetrics( 600, 0, 35, -15, 570, 625 ),
        new CharMetrics( 600, 0, 35, -15, 570, 678 ), new CharMetrics( 600, 0, -4, -15, 601, 454 ),
        new CharMetrics( 600, 0, 40, -206, 545, 459 ), new CharMetrics( 600, 0, 40, -15, 563, 661 ),
        new CharMetrics( 600, 0, 40, -15, 563, 661 ), new CharMetrics( 600, 0, 40, -15, 563, 657 ),
        new CharMetrics( 600, 0, 40, -15, 563, 625 ), new CharMetrics( 600, 0, 77, 0, 523, 661 ),
        new CharMetrics( 600, 0, 77, 0, 523, 661 ), new CharMetrics( 600, 0, 63, 0, 523, 657 ),
        new CharMetrics( 600, 0, 77, 0, 523, 625 ), new CharMetrics( 600, 0, 58, -27, 543, 626 ),
        new CharMetrics( 600, 0, 18, 0, 592, 636 ), new CharMetrics( 600, 0, 30, -15, 570, 661 ),
        new CharMetrics( 600, 0, 30, -15, 570, 661 ), new CharMetrics( 600, 0, 30, -15, 570, 657 ),
        new CharMetrics( 600, 0, 30, -15, 570, 636 ), new CharMetrics( 600, 0, 30, -15, 570, 625 ),
        new CharMetrics( 600, 0, 71, 16, 529, 500 ), new CharMetrics( 600, 0, 30, -24, 570, 463 ),
        new CharMetrics( 600, 0, -1, -15, 569, 661 ), new CharMetrics( 600, 0, -1, -15, 569, 661 ),
        new CharMetrics( 600, 0, -1, -15, 569, 657 ), new CharMetrics( 600, 0, -1, -15, 569, 625 ),
        new CharMetrics( 600, 0, -4, -142, 601, 661 ), new CharMetrics( 600, 0, -14, -142, 570, 626 ),
        new CharMetrics( 600, 0, -4, -142, 601, 625 )};

    MonospaceBold()
    {
        super( true, 626, -142, new CharMetrics( 0, 0, -113, -250, 749, 801 ), metrics );
    }

}
